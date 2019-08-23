package com.update.module_base.net;

import android.util.LruCache;

import com.update.module_base.GlobalConfigs;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static LruCache<String, Retrofit> mServiceMap = new LruCache<>(5);

    private ServiceGenerator() {
    }

    /**
     * 使用默认 host 创建retrofit
     */
    public static <T> T getService(Class<T> serviceClass) {
        return getCustomService(GlobalConfigs.getBaseDomain(), serviceClass);
    }

    /**
     * 使用指定 host 创建retrofit
     * 适用于需要动态替换 host 的需求
     */
    public static <T> T getCustomService(String domain, Class<T> serviceClass) {
        synchronized (ServiceGenerator.class) {
            Retrofit retrofit = mServiceMap.get(domain);
            if (retrofit == null) {
                retrofit = getRetrofit(domain);
                //只缓存最常用的
                mServiceMap.put(domain, retrofit);
            }
            return createServiceFrom(retrofit, serviceClass);
        }
    }

    private static <T> T createServiceFrom(Retrofit retrofit, Class<T> serviceClass) {
        return retrofit.create(serviceClass);
    }

    private static Retrofit getRetrofit(String base_url) {
        return new Retrofit.Builder()
                .baseUrl(base_url)
                .client(OKHttpFactory.instance().getOkHttp())
                .addConverterFactory(GsonConverterFactory.create())         //返回内容的转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())  //请求Call的转换器
                .build();
    }


}