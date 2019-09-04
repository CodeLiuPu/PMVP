package com.update.net;


import com.update.net.interceptor.log.Level;
import com.update.net.interceptor.log.LogInterceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/**
 * @author : liupu
 * date   : 2019/8/23
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class OKHttpFactory {
    public final static int TIME_OUT = 10;

    private final List<Interceptor> interceptors = new ArrayList<>();

    private OKHttpFactory() {

    }

    public static OKHttpFactory instance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        static final OKHttpFactory INSTANCE = new OKHttpFactory();
    }

    public void setInterceptors(List<Interceptor> interceptors) {
        this.interceptors.clear();
        this.interceptors.addAll(interceptors);
    }

    public OkHttpClient getOkHttp() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS);

        if (interceptors.size() > 0) {
            for (Interceptor interceptor : interceptors) {
                builder.addInterceptor(interceptor);
            }
        }

        if (NetConfig.isDebug()) {
//            builder.addInterceptor(new LogInterceptor.Builder()
//                    .logLevel(Level.BODY)
//                    .build());
        }

        return builder.build();
    }

}