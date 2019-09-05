package com.update.base.utils;

import android.content.res.Resources;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;

import com.update.base.GlobalContext;

/**
 * @author : liupu
 * date    : 2019/9/5
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public class ResUtils {
    private ResUtils() {
    }

    public static Resources getResources() {
        return GlobalContext.getApp().getResources();
    }

    @ColorInt
    @Deprecated
    public int getColor(@ColorRes int id) {
        return getResources().getColor(id);
    }

    public static String getString(@StringRes int id) {
        return getResources().getString(id);
    }

}
