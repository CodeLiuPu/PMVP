package com.update.base.utils;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.update.base.GlobalContext;


/**
 * @author : liupu
 * date   : 2019/8/24
 * desc   : App相关工具类
 * Github : https://github.com/CodeLiuPu/
 */
public final class AppUtils extends GlobalContext {

    private AppUtils() {
    }

    /**
     * 获取当前应用程序名称
     */
    public static synchronized String getAppName() {
        try {
            PackageManager packageManager = getApp().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    getApp().getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return getApp().getResources().getString(labelRes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取当前应用的版本名称
     */
    public static synchronized String getVersionName() {
        try {
            PackageManager packageManager = getApp().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    getApp().getPackageName(), 0);
            return packageInfo.versionName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }


    /**
     * 获取当前应用的版本号
     */
    public static synchronized int getVersionCode() {
        try {
            PackageManager packageManager = getApp().getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    getApp().getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
