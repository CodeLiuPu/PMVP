package com.update.net.interceptor.log;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

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
        Request request = chain.request();

        Response response;
        try {
            response = chain.proceed(request);
        } catch (Exception e) {
            throw e;
        }


        return response;
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
