package com.update.pmvp;

import android.app.Application;

import com.update.module_base.GlobalConfigs;
import com.update.net.NetConfig;

/**
 * @author : liupu
 * date   : 2019/8/21
 * desc   :
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new GlobalConfigs()
                .init(this)
                .setDebug(true);
        NetConfig.setDebug(true);
    }
}
