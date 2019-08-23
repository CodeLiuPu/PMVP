package com.update.module_base;

import android.content.Context;

import com.update.module_base.utils.log.LogConfig;
import com.update.module_base.utils.log.LogUtil;

/**
 * @author : liupu
 * date   : 2019/4/23
 * desc   :
 */
public class GlobalConfigs {

    private static boolean isDebug = true;
    private static Context context;

    public GlobalConfigs init(Context context) {
        GlobalConfigs.context = context;
        return this;
    }

    public GlobalConfigs setDebug(boolean isDebug) {
        GlobalConfigs.isDebug = isDebug;
        LogUtil.setConfig(new LogConfig("Hello", true));
        return this;
    }

    public static boolean isDebug() {
        return isDebug;
    }

    public static Context getContext() {
        if (context == null) {
            throw new NullPointerException("u should init GlobalConfigs first");
        }
        return context;
    }

}
