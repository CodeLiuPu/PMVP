package com.update.base.utils;

import android.app.Activity;
import android.app.Dialog;
import android.support.annotation.IdRes;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;


/**
 * @author : liupu
 * date    : 2019/9/7
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public final class ViewUtils {

    private ViewUtils() {
    }

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

    public static boolean isVisible(View view) {
        return view.getVisibility() == View.VISIBLE;
    }

    public static boolean isGone(View view) {
        return view.getVisibility() == View.GONE;
    }

    public static void setGone(View... view) {
        setVisibility(View.GONE, view);
    }

    public static void setInvisible(View... view) {
        setVisibility(View.INVISIBLE, view);
    }

    public static void setVisible(View... view) {
        setVisibility(View.VISIBLE, view);
    }

    public static void setVisibility(boolean isVisible, View... views) {
        if (isVisible) {
            setVisible(views);
        } else {
            setGone(views);
        }
    }

    public static void setVisibility(int visibility, View... views) {
        for (View view : views) {
            if (view != null) {
                if (view instanceof ViewStub || view.getVisibility() != visibility) {
                    view.setVisibility(visibility);
                }
            }
        }
    }
}
