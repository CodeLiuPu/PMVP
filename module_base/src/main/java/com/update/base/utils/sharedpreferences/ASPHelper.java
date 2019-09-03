package com.update.base.utils.sharedpreferences;

import android.content.SharedPreferences;
import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author : liupu
 * date   : 2019/8/22
 * desc   :
 * github : https://github.com/CodeLiuPu/
 */
class ASPHelper implements ISPHelper {
    protected SharedPreferences mSharedPreferences;
    protected SharedPreferences.Editor editor;

    public ASPHelper(SharedPreferences sharedPreferences) {
        this.mSharedPreferences = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    @Override
    public ISPHelper putBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        return this;
    }

    @Override
    public boolean getBoolean(String key, boolean defValue) {
        return mSharedPreferences.getBoolean(key, defValue);
    }

    @Override
    public ISPHelper putInt(String key, int value) {
        editor.putInt(key, value);
        return this;
    }

    @Override
    public int getInt(String key, int defValue) {
        return mSharedPreferences.getInt(key, defValue);
    }

    @Override
    public ISPHelper putLong(String key, long value) {
        editor.putLong(key, value);
        return this;
    }

    @Override
    public long getLong(String key, long defValue) {
        return mSharedPreferences.getLong(key, defValue);
    }

    @Override
    public ISPHelper putString(String key, String value) {
        editor.putString(key, value);
        return this;
    }

    @Override
    public String getString(String key, String defValue) {
        return mSharedPreferences.getString(key, defValue);
    }

    @Override
    public ISPHelper saveObject(String key, Object object) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeObject(object);
            String oAuth_Base64 = new String(Base64.encode(baos.toByteArray(), Base64.DEFAULT));
            editor.putString(key, oAuth_Base64);
            return this;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public <T> T readObject(String key) {
        Object object = null;
        String string = mSharedPreferences.getString(key, "");
        if ("".equals(string)) {
            return null;
        }
        byte[] base64 = Base64.decode(string.getBytes(), Base64.DEFAULT);
        try (ByteArrayInputStream bais = new ByteArrayInputStream(base64);
             ObjectInputStream bis = new ObjectInputStream(bais)) {
            object = bis.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) object;
    }

    @Override
    public void remove(String key) {
        editor.remove(key);
    }

    @Override
    public void clear() {
        editor.clear();
    }

    @Override
    public boolean commit() {
        return editor.commit();
    }

    @Override
    public void apply() {
        editor.apply();
    }
}
