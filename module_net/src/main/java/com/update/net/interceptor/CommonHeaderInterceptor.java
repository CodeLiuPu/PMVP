package com.update.net.interceptor;


import com.update.net.helper.ICommonHeadersHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;

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

    ICommonHeadersHelper headersHelper;

    public CommonHeaderInterceptor(ICommonHeadersHelper headersHelper) {
        this.headersHelper = headersHelper;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Map<String, String> headers = headersHelper.getCommonHeaders();

        if (headers == null || headers.isEmpty()) {
            return chain.proceed(chain.request());
        }

        Request request = chain.request();
        Request.Builder reqBuilder = request.newBuilder();
        reqBuilder.headers(Headers.of(headers));
        return chain.proceed(reqBuilder.build());
    }
}
