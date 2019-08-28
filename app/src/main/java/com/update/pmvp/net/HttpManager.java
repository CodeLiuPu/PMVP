package com.update.pmvp.net;


import com.update.net.OKHttpFactory;
import com.update.net.ServiceGenerator;
import com.update.net.interceptor.CommonHeaderInterceptor;
import com.update.net.interceptor.CommonParamInterceptor;
import com.update.net.interceptor.DynamicUrlInterceptor;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;

/**
 * @author : liupu
 * date   : 2019/8/23
 * desc   :
 */
public class HttpManager {

    static {
        final List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new DynamicUrlInterceptor());
        interceptors.add(new CommonHeaderInterceptor(new ParamsUtils()));
        interceptors.add(new CommonParamInterceptor(new ParamsUtils()));
        OKHttpFactory.instance().setInterceptors(interceptors);
    }

    public static HttpService service() {
        return ServiceGenerator.getCustomService(HttpURL.baseUrl(), HttpService.class);
    }

    public static HttpService service(String domain) {
        return ServiceGenerator.getCustomService(domain, HttpService.class);
    }

}
