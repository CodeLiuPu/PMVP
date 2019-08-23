package com.update.net.interceptor;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author : liupu
 * date   : 2019/8/22
 * desc   : 添加通用 header 的拦截器
 */
public class CommonHeaderInterceptor implements Interceptor {

    private final Map<String, String> headers = new HashMap<>();

    public CommonHeaderInterceptor(Map<String, String> headers) {
        if (headers != null && !headers.isEmpty()) {
            this.headers.putAll(headers);
        }
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (headers == null || headers.isEmpty()) {
            return chain.proceed(chain.request());
        }

        Request request = chain.request();
        Request.Builder reqBuilder = request.newBuilder();
        reqBuilder.headers(Headers.of(headers));
        return chain.proceed(reqBuilder.build());
    }
}
