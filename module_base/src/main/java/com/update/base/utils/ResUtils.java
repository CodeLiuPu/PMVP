package com.update.base.utils;

import android.content.res.Resources;
import android.support.annotation.ArrayRes;
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
public final class ResUtils {
    private ResUtils() {
    }

    public static Resources getResources() {
        return GlobalContext.getApp().getResources();
    }

    @ColorInt
    public int getColor(@ColorRes int id) {
        return getResources().getColor(id);
    }

    public static String getString(@StringRes int id) {
        return getResources().getString(id);
    }

    /**
     * 从arrays.xml中读取array[]
     */
    public static String[] getStringArray(@ArrayRes int resId) {
        return getResources().getStringArray(resId);
    }

    /**
     * 从dimens.xml里读取dimen
     */
    public static int getDimen(int resId) {
        return getResources().getDimensionPixelSize(resId);
    }
}
