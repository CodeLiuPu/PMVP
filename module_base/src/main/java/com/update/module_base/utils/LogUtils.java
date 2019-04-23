package com.update.module_base.utils;

import com.update.module_base.GlobalConfig;

import timber.log.Timber;

/**
 * @author : liupu
 * date   : 2019/4/19
 * desc   :
 */
public class LogUtils {

    private static final String TAG = "TAG_UPDATE";

    public static void i(String msg) {
        i(TAG, msg);
    }

    public static void i(String tag, String msg) {
        if (GlobalConfig.IS_DEBUG) {
            Timber.tag(tag).i(msg);
        }
    }

    public static void e(String msg) {
        e(TAG, msg);
    }

    public static void e(String tag, String msg) {
        if (GlobalConfig.IS_DEBUG) {
            Timber.tag(tag).e(msg);
        }
    }

}
