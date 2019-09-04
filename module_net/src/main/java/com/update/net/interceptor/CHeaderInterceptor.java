package com.update.net.interceptor;


import com.update.net.helper.ICHeadersHelper;

import java.io.IOException;
import java.util.Map;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author : liupu
 * date   : 2019/8/22
 * desc   : 添加通用 header 的拦截器
 * github : https://github.com/CodeLiuPu/
 */
public class CHeaderInterceptor implements Interceptor {

    private ICHeadersHelper headersHelper;

    public CHeaderInterceptor(ICHeadersHelper headersHelper) {
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
