package com.update.base.utils;


import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * @author : liupu
 * date    : 2019/9/8
 * desc    : Fragment 相关工具类
 * github : https://github.com/CodeLiuPu/
 */
public final class FragmentUtils {

    private FragmentUtils() {

    }

    public static void addFragmentIntoActivity(@NonNull FragmentActivity activity, @NonNull Fragment fragment, @IdRes int containerId) {
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.replace(containerId, fragment);
        ft.commitAllowingStateLoss();
    }


    public static void addFragmentIntoFragment(@NonNull Fragment baseFragment, @NonNull Fragment fragment, @IdRes int containerId) {
        FragmentTransaction ft = baseFragment.getChildFragmentManager().beginTransaction();
        ft.replace(containerId, fragment);
        ft.commitAllowingStateLoss();
    }
}
