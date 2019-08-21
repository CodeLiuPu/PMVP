package com.update.module_base;

import com.update.module_base.utils.log.LogConfig;
import com.update.module_base.utils.log.LogUtil;

/**
 * @author : liupu
 * date   : 2019/4/23
 * desc   :
 */
public class GlobalConfigs {
    private static boolean isDebug = true;

    public static boolean isDebug() {
        return isDebug;
    }

    public static void setDebug(boolean isDebug) {
        GlobalConfigs.isDebug = isDebug;
        LogUtil.setConfig(new LogConfig("Hello", true));
    }
}
