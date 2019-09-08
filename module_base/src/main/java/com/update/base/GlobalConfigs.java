package com.update.base;

import android.app.Application;

import com.update.base.utils.log.LogConfig;
import com.update.base.utils.log.LogUtil;

/**
 * @author : liupu
 * date   : 2019/4/23
 * desc   : 全局配置项
 * github : https://github.com/CodeLiuPu/
 */
public class GlobalConfigs {

    private static boolean isDebug = true;

    public GlobalConfigs(Application app) {
        GlobalContext.init(app);
    }

    public GlobalConfigs setDebug(boolean isDebug) {
        GlobalConfigs.isDebug = isDebug;
        LogUtil.setConfig(new LogConfig("Hello", true));
        return this;
    }

    public static boolean isDebug() {
        return isDebug;
    }

}
