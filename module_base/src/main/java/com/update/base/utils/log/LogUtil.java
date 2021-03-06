package com.update.base.utils.log;

import android.util.Log;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public final class LogUtil {

    private static String TAG = "TAG_UPDATE";

    private static boolean showLog = false;

    public static void setConfig(LogConfig config) {
        LogUtil.TAG = config.tag;
        LogUtil.showLog = config.isDebug;
    }

    public static void v(String msg) {
        if (showLog) {
            v(TAG, msg);
        }
    }

    public static void v(String tag, String msg) {
        if (showLog) {
            Log.v(tag, msg);
        }
    }

    public static void d(String msg) {
        if (showLog) {
            d(TAG, msg);
        }
    }

    public static void d(String tag, String msg) {
        if (showLog) {
            Log.d(tag, msg);
        }
    }

    public static void i(String msg) {
        if (showLog) {
            i(TAG, msg);
        }
    }

    public static void i(String tag, String msg) {
        if (showLog) {
            Log.i(tag, msg);
        }
    }

    public static void w(String msg) {
        if (showLog) {
            w(TAG, msg);
        }
    }

    public static void w(String tag, String msg) {
        if (showLog) {
            Log.w(tag, msg);
        }
    }

    public static void e(String msg) {
        if (showLog) {
            e(TAG, msg);
        }
    }

    public static void e(String tag, String msg) {
        if (showLog) {
            Log.e(tag, msg);
        }
    }

}
