package com.update.module_base.utils.sharedpreferences;

/**
 * @author : liupu
 * date   : 2019/4/20
 * desc   : SharePreferences 工具类
 */
public class PreferenceHelper {
    public static ISPHelper helper(String spName) {
        return PathSPHelper.helper(spName);
    }

    public static ISPHelper helper() {
        return DefaultSPHelper.helper();
    }
}