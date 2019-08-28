package com.update.module_base.utils.log;

import android.text.TextUtils;

/**
 * @author : liupu
 * date   : 2019/8/22
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class LogConfig {
    String tag = "";
    boolean isDebug = false;

    public LogConfig(String tag, boolean isDebug) {
        if (!TextUtils.isEmpty(tag)) {
            this.tag = tag;
        }
        this.isDebug = isDebug;
    }
}