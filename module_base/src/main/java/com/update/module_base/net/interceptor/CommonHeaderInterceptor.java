package com.update.module_base.net.interceptor;


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
 * desc   : 通用header的拦截器
 */
public class CommonHeaderInterceptor implements Interceptor {

    private final Map<String, String> maps = new HashMap<>();

    public CommonHeaderInterceptor(Map<String, String> params) {
        if (params != null && !params.isEmpty()) {
            this.maps.putAll(params);
        }
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (maps == null || maps.isEmpty()) {

            return chain.proceed(chain.request());
        }

        Request request = chain.request();
        Request.Builder reqBuilder = request.newBuilder();
        reqBuilder.headers(Headers.of(maps));
        return chain.proceed(reqBuilder.build());
    }
}
