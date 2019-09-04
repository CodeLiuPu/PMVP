package com.update.pmvp.net;


import com.update.net.OKHttpFactory;
import com.update.net.ServiceGenerator;
import com.update.net.interceptor.CHeaderInterceptor;
import com.update.net.interceptor.CParamInterceptor;
import com.update.net.interceptor.DynamicUrlInterceptor;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Interceptor;

/**
 * @author : liupu
 * date   : 2019/8/23
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class HttpManager {

    static {
        final List<Interceptor> interceptors = new ArrayList<>();
        interceptors.add(new DynamicUrlInterceptor());
        interceptors.add(new CHeaderInterceptor(new ParamsUtils()));
        interceptors.add(new CParamInterceptor(new ParamsUtils()));
        OKHttpFactory.instance().setInterceptors(interceptors);
    }

    public static HttpService service() {
        return ServiceGenerator.getCustomService(HttpURL.baseUrl(), HttpService.class);
    }

    public static HttpService service(String domain) {
        return ServiceGenerator.getCustomService(domain, HttpService.class);
    }

}
