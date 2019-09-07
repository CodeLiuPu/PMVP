package com.update.base;

import android.app.Application;
import android.support.annotation.NonNull;

/**
 * @author : liupu
 * date   : 2019/8/24
 * desc   :
 * Github : https://github.com/CodeLiuPu/
 */
public class GlobalContext {

    private static Application app;

    protected GlobalContext() {
    }

    public static void init(@NonNull final Application app) {
        GlobalContext.app = app;
    }

    public static Application getApp() {
        if (app == null) {
            throw new NullPointerException("u should init GlobalConfigs first");
        }
        return GlobalContext.app;
    }
}
