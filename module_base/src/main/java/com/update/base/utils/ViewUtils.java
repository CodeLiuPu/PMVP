package com.update.base.utils;

import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.IdRes;
import android.view.View;
import android.view.Window;

/**
 * @author : liupu
 * date    : 2019/9/7
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public final class ViewUtils {

    @SuppressWarnings("unchecked")
    public static <V extends View> V findViewById(Activity ac, @IdRes int id) {
        return (V) ac.findViewById(id);
    }


    @SuppressWarnings("unchecked")
    public static <V extends View> V findViewById(View view, @IdRes int id) {
        return (V) view.findViewById(id);
    }


    @SuppressWarnings("unchecked")
    public static <V extends View> V findViewById(Dialog view, @IdRes int id) {
        return (V) view.findViewById(id);
    }


    @SuppressWarnings("unchecked")
    public static <V extends View> V findViewById(Window window, @IdRes int id) {
        return (V) window.findViewById(id);
    }
}
