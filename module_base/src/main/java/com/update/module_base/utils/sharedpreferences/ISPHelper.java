package com.update.module_base.utils.sharedpreferences;

/**
 * @author : liupu
 * date   : 2019/8/22
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
public interface ISPHelper {

    ISPHelper putBoolean(String key, boolean value);

    boolean getBoolean(String key, boolean defValue);

    ISPHelper putInt(String key, int value);

    int getInt(String key, int defValue);

    ISPHelper putLong(String key, long value);

    long getLong(String key, long defValue);

    ISPHelper putString(String key, String value);

    String getString(String key, String defValue);

    ISPHelper saveObject(String key, Object object);

    <T> T readObject(String key);

    void remove(String key);

    void clear();

    boolean commit();

    void apply();

}
