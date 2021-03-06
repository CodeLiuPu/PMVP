package com.update.base.utils.sharedpreferences;

/**
 * @author : liupu
 * date   : 2019/4/20
 * desc   : SharePreferences 工具类
 * github : https://github.com/CodeLiuPu/
 */
public class SPHelper {
    public static ISPHelper helper(String spName) {
        return SPFactory.create(spName);
    }

    public static ISPHelper helper() {
        return SPFactory.create();
    }
}
