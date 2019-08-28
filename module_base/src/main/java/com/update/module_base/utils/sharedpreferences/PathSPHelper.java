package com.update.module_base.utils.sharedpreferences;

import android.annotation.SuppressLint;
import android.content.Context;

import com.update.module_base.GlobalConfigs;

import java.util.LinkedHashMap;

/**
 * @author : liupu
 * date   : 2019/8/22
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class PathSPHelper extends ASPHelper {
    private static final LinkedHashMap<String, PathSPHelper> helpers = new LinkedHashMap<>(3, 0.75F, true);

    public static PathSPHelper helper(String spName) {
        synchronized (PathSPHelper.class) {
            PathSPHelper manager = helpers.get(spName);
            if (manager == null) {
                manager = new PathSPHelper(spName);
                helpers.put(spName, manager);
            }
            return manager;
        }
    }

    @SuppressLint("CommitPrefEdits")
    private PathSPHelper(String spName) {
        this.mSharedPreferences = GlobalConfigs.getContext().getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = this.mSharedPreferences.edit();
    }
}
