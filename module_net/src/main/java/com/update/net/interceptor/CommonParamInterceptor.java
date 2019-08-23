package com.update.net.interceptor;


import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author : liupu
 * date   : 2019/8/22
 * desc   : 添加通用 params 的拦截器
 */
public class CommonParamInterceptor implements Interceptor {

    private final Map<String, Object> params = new HashMap<>();//这里是我们的公共参数

    public CommonParamInterceptor(Map<String, Object> params) {
        if (params != null && !params.isEmpty()) {
            this.params.putAll(params);
        }
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (params == null || params.isEmpty()) {
            return chain.proceed(chain.request());
        }

        Request request = chain.request();
        // 添加公共的新的参数
        HttpUrl.Builder authorizedUrlBuilder = request.url().newBuilder();

        Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> entry = it.next();

            String key = entry.getKey();
            Object obj = entry.getValue();
            if (key != null && obj != null) {
                String value = URLDecoder.decode(entry.getValue().toString());//如果是中文/其他字符，会直接把字符串用BASE64加密
                authorizedUrlBuilder.addQueryParameter(key, value);
            }
        }
        //生成新的请求
        Request newrequest = request.newBuilder()
                .method(request.method(), request.body())
                .url(authorizedUrlBuilder.build())
                .build();

        return chain.proceed(newrequest);

    }
}
