package com.update.pmvp;

import android.app.Application;

import com.update.module_base.GlobalConfigs;

/**
 * @author : liupu
 * date   : 2019/8/21
 * desc   :
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GlobalConfigs.setDebug(true);
    }
}
