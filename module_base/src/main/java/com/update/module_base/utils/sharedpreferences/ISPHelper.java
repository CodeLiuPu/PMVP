package com.update.module_base.utils.sharedpreferences;

/**
 * @author : liupu
 * date   : 2019/8/22
 * desc   :
 */
public interface ISPHelper {

    void putBoolean(String key, boolean value);
    boolean getBoolean(String key, boolean defValue);

    void putInt(String key, int value);
    int getInt(String key, int defValue);

    void putLong(String key, long value);
    long getLong(String key, long defValue);

    void putString(String key, String value);
    String getString(String key, String defValue);

    void saveObject(String key, Object object);
    <T> T readObject(String key);

    void remove(String key);
    void clear();
}
