package com.update.module_base.utils.sharedpreferences;

import android.annotation.SuppressLint;
import android.preference.PreferenceManager;

import com.update.module_base.GlobalConfigs;

/**
 * @author : liupu
 * date   : 2019/8/22
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public class DefaultSPHelper extends ASPHelper {

    public static DefaultSPHelper helper() {
        return DefaultSPHelper.Holder.INSTANCE;
    }

    @SuppressLint("CommitPrefEdits")
    private DefaultSPHelper() {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(GlobalConfigs.getContext());
        editor = mSharedPreferences.edit();
    }

    private static final class Holder {
        private static final DefaultSPHelper INSTANCE = new DefaultSPHelper();
    }
}
