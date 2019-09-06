package com.update.pmvp;

import android.app.Application;

import com.update.base.GlobalConfigs;
import com.update.net.NetConfig;
import com.update.net.interceptor.log.Level;

/**
 * @author : liupu
 * date   : 2019/8/21
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new GlobalConfigs(this)
                .setDebug(true);
        new NetConfig()
                .setDebug(true)
                .setLogLevel(Level.ERROR)
                .setTag("okhttp_tag");
    }
}
