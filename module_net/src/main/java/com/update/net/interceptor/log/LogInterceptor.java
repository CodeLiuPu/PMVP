package com.update.net.interceptor.log;

import java.io.EOFException;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;

/**
 * @author : liupu
 * date   : 2019/9/4
 * desc   : 日志拦截器
 * github : https://github.com/CodeLiuPu/
 */
public final class LogInterceptor implements Interceptor {

    private static final Charset UTF8 = Charset.forName("UTF-8");
    private volatile Printer printer;

    private LogInterceptor(Builder builder) {
        this.printer = new Printer.Builder()
                .logLevel(builder.level)
                .tag(builder.tag)
                .build();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        // Request
        Request request = chain.request();
        RequestBody requestBody = request.body();
        boolean hasRequestBody = requestBody != null;

        // 1. Request Start
        Connection connection = chain.connection();
        String requestStartMessage = "--> "
                + request.method()
                + ' ' + request.url()
                + (connection != null ? " " + connection.protocol() : "");
        if (hasRequestBody) {
            requestStartMessage += " (" + requestBody.contentLength() + "-byte body)";
        }
        printer.log(requestStartMessage);

        if (hasRequestBody) {
            if (requestBody.contentType() != null) {
                printer.log("Content-Type: " + requestBody.contentType());
            }
            if (requestBody.contentLength() != -1) {
                printer.log("Content-Length: " + requestBody.contentLength());
            }
        }

        // 2. Request Headers
        Headers requestHeaders = request.headers();
        for (int i = 0, count = requestHeaders.size(); i < count; i++) {
            String name = requestHeaders.name(i);
            // Skip headers from the request body as they are explicitly logged above.
            if (!"Content-Type".equalsIgnoreCase(name) && !"Content-Length".equalsIgnoreCase(name)) {
                printer.log(name + ": " + requestHeaders.value(i));
            }
        }

        // 3. Request Body
        if (!hasRequestBody) {
            printer.log("--> END " + request.method());
        } else if (bodyHasUnknownEncoding(request.headers())) {
            printer.log("--> END " + request.method() + " (encoded body omitted)");
        } else {
            Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);

            Charset charset = UTF8;
            MediaType contentType = requestBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }

            printer.log("");
            if (isPlaintext(buffer)) {
                String message = buffer.readString(charset);

                /**
                 // 解密逻辑
                 // String s = DESCryptUtils.decryptBasedDes(message, AppConfig.DES_KEY);
                 // printer.log(HCNetHelper.KEY_JSONPARAMS + "=" + s);
                 */
                try {
                    printer.log(URLDecoder.decode(message));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                printer.log("--> END " + request.method()
                        + " (" + requestBody.contentLength() + "-byte body)");
            } else {
                printer.log("--> END " + request.method() + " (binary "
                        + requestBody.contentLength() + "-byte body omitted)");
            }
        }

        // Response
        long startNs = System.nanoTime();
        Response response;
        try {
            response = chain.proceed(request);
        } catch (Exception e) {
            printer.log("<-- HTTP FAILED: " + e);
            throw e;
        }
        long tookMs = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNs);

        // 4. Response Start
        ResponseBody responseBody = response.body();
        long contentLength = responseBody.contentLength();
        String bodySize = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
        printer.log("<-- "
                + response.code()
                + (response.message().isEmpty() ? "" : ' ' + response.message())
                + ' ' + response.request().url()
                + " (" + tookMs + "ms" + (", " + bodySize + " body") + ')');

        // 5. Response Headers
        Headers responseHeaders = response.headers();
        for (int i = 0, count = responseHeaders.size(); i < count; i++) {
            printer.log(responseHeaders.name(i) + ": " + responseHeaders.value(i));
        }

        // 5. Response Body
        boolean hasResponseBody = HttpHeaders.hasBody(response);

        if (!hasResponseBody) {
            printer.log("<-- END HTTP");
        } else if (bodyHasUnknownEncoding(response.headers())) {
            printer.log("<-- END HTTP (encoded body omitted)");
        } else {
            BufferedSource source = responseBody.source();
            source.request(Long.MAX_VALUE); // Buffer the entire body.
            Buffer buffer = source.buffer();

            Charset charset = UTF8;
            MediaType contentType = responseBody.contentType();
            if (contentType != null) {
                charset = contentType.charset(UTF8);
            }

            if (!isPlaintext(buffer)) {
                printer.log("");
                printer.log("<-- END HTTP (binary " + buffer.size() + "-byte body omitted)");
                return response;
            }

            // Response Body 内容
            if (contentLength != 0) {
                printer.log("");
                String message = buffer.clone().readString(charset);

                /**
                 // 解密逻辑
                 // String s = DESCryptUtils.decryptBasedDes(message, AppConfig.DES_KEY);
                 // printer.log(s);
                 */
                printer.log(message);
            }

            // gzip
            Long gzippedLength = null;
            if ("gzip".equalsIgnoreCase(responseHeaders.get("Content-Encoding"))) {
                gzippedLength = buffer.size();
                GzipSource gzippedResponseBody = null;
                try {
                    gzippedResponseBody = new GzipSource(buffer.clone());
                    buffer = new Buffer();
                    buffer.writeAll(gzippedResponseBody);
                } finally {
                    if (gzippedResponseBody != null) {
                        gzippedResponseBody.close();
                    }
                }
            }

            if (gzippedLength != null) {
                printer.log("<-- END HTTP (" + buffer.size() + "-byte, "
                        + gzippedLength + "-gzipped-byte body)");
            } else {
                printer.log("<-- END HTTP (" + buffer.size() + "-byte body)");
            }
        }

        return response;
    }

    /**
     * Returns true if the body in question probably contains human readable text. Uses a small sample
     * of code points to detect unicode control characters commonly used in binary file signatures.
     */
    static boolean isPlaintext(Buffer buffer) {
        try {
            Buffer prefix = new Buffer();
            long byteCount = buffer.size() < 64 ? buffer.size() : 64;
            buffer.copyTo(prefix, 0, byteCount);
            for (int i = 0; i < 16; i++) {
                if (prefix.exhausted()) {
                    break;
                }
                int codePoint = prefix.readUtf8CodePoint();
                if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException e) {
            return false; // Truncated UTF-8 sequence.
        }
    }

    private boolean bodyHasUnknownEncoding(Headers headers) {
        String contentEncoding = headers.get("Content-Encoding");
        return contentEncoding != null
                && !contentEncoding.equalsIgnoreCase("identity")
                && !contentEncoding.equalsIgnoreCase("gzip");
    }

    public static class Builder {
        private Level level = Level.INFO;
        private String tag = "Log_default";

        public Builder logLevel(Level level) {
            this.level = level;
            return this;
        }

        public Builder tag(String tag) {
            this.tag = tag;
            return this;
        }

        public LogInterceptor build() {
            return new LogInterceptor(this);
        }
    }
}
