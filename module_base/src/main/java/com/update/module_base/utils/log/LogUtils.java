package com.update.module_base.utils.log;

import android.util.Log;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 */
public final class LogUtils {

    private static String TAG = "TAG_UPDATE";

    private static boolean showLog = false;

    public static void setConfig(LogConfig config) {
        LogUtils.TAG = config.tag;
        LogUtils.showLog = config.isDebug;
    }

    public static void v(String msg) {
        if (showLog) {
            Log.v(TAG, msg);
        }
    }

    public static void d(String msg) {
        if (showLog) {
            Log.d(TAG, msg);
        }
    }

    public static void i(String msg) {
        if (showLog) {
            Log.i(TAG, msg);
        }
    }

    public static void w(String msg) {
        if (showLog) {
            Log.w(TAG, msg);
        }
    }

    public static void e(String msg) {
        if (showLog) {
            Log.e(TAG, msg);
        }
    }

}
