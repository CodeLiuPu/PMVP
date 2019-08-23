package com.update.pmvp.net;

import com.update.module_base.net.OKHttpFactory;
import com.update.module_base.net.ServiceGenerator;
import com.update.module_base.net.interceptor.BaseUrlInterceptor;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;

/**
 * @author : liupu
 * date   : 2019/8/23
 * desc   :
 */
public class HttpManager<S> {
    private S service;

    static {
        final List<Interceptor> interceptors = new ArrayList<>();
        BaseUrlInterceptor baseUrlInterceptor = new BaseUrlInterceptor();
        interceptors.add(baseUrlInterceptor);
        OKHttpFactory.instance().setInterceptors(interceptors);
    }

    public static HttpService service() {
        return service(HttpService.class);
    }

    private static <H> H service(Class<H> clazz) {
        HttpManager<H> httpManager = new HttpManager();
        httpManager.service = ServiceGenerator.getCustomService(HttpURL.baseUrl(), clazz);
        return httpManager.service;
    }

    public static HttpService service(String domain) {
        return service(domain, HttpService.class);
    }

    private static <H> H service(String domain, Class<H> clazz) {
        HttpManager<H> engin = new HttpManager();
        engin.service = ServiceGenerator.getCustomService(domain, clazz);
        return engin.service;
    }

}
