package com.update.pmvp.net;

import com.update.module_base.net.OKHttpFactory;
import com.update.module_base.net.interceptor.BaseUrlInterceptor;

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
        BaseUrlInterceptor baseUrlInterceptor = new BaseUrlInterceptor();
        interceptors.add(baseUrlInterceptor);
        OKHttpFactory.instance().setInterceptors(interceptors);
    }
}
