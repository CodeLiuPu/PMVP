package com.update.base.utils.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.update.base.GlobalConfigs;
import com.update.base.GlobalContext;

import java.util.LinkedHashMap;

/**
 * @author : liupu
 * date   : 2019/9/3
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
class SPFactory {
    private static final LinkedHashMap<String, ISPHelper> helpers = new LinkedHashMap<>(3, 0.75F, true);

    static ISPHelper create() {
        return generateDefaultSpHelper();
    }

    static ISPHelper create(String spName) {
        return generatePathSpHelper(spName);
    }

    private static ISPHelper generateDefaultSpHelper() {
        return DefaultHolder.defaultHelper;
    }

    private static ISPHelper generatePathSpHelper(String spName) {
        synchronized (ISPHelper.class) {
            ISPHelper manager = helpers.get(spName);
            if (manager == null) {
                SharedPreferences mSharedPreferences =
                        GlobalContext.getApp().getSharedPreferences(spName, Context.MODE_PRIVATE);
                manager = new ASPHelper(mSharedPreferences);
                helpers.put(spName, manager);
            }
            return manager;
        }
    }

    private static final class DefaultHolder {
        private static final ISPHelper defaultHelper =
                new ASPHelper(PreferenceManager.getDefaultSharedPreferences(GlobalContext.getApp()));
    }
}
