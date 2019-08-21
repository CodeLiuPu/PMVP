package com.update.module_base.net;


import com.update.module_base.GlobalConfigs;
import com.update.module_base.net.interceptor.HttpLoggingInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author : liupu
 * date   : 2019/4/20
 * desc   :
 */
public abstract class BaseRetrofitManager<T> {
    private static final String URL = "";

    private final static Retrofit retrofit;

    static {

        OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS);

        if (GlobalConfigs.isDebug()) {
            okHttpClientBuilder.addInterceptor(new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY));
        }

        retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClientBuilder.build())
                .build();
    }

    //获取创建的服务对象
    public static <T> T createApi(final Class<T> service) {
        return retrofit.create(service);
    }

}
