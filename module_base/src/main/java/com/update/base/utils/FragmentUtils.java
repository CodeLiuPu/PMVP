package com.update.base.utils;


import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

/**
 * @author : liupu
 * date    : 2019/9/8
 * desc    :
 * github : https://github.com/CodeLiuPu/
 */
public final class FragmentUtils {

    private FragmentUtils() {

    }

    public static void addFragmentIntoActivity(FragmentActivity activity, Fragment fragment, @IdRes int containerId) {
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        ft.replace(containerId, fragment);
        ft.commitAllowingStateLoss();
    }


    public static void addFragmentIntoFragment(Fragment baseFragment, Fragment fragment, @IdRes int containerId) {
        FragmentTransaction ft = baseFragment.getChildFragmentManager().beginTransaction();
        ft.replace(containerId, fragment);
        ft.commitAllowingStateLoss();
    }
}
