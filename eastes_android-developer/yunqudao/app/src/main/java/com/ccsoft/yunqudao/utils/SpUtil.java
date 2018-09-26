package com.ccsoft.yunqudao.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.ccsoft.yunqudao.data.AppConstants;

/**
 * @author: Pein
 * @data: 2018/4/8 0008
 */

public class SpUtil {
    private static boolean isInit = false;
    private static SharedPreferences mSharedPreferences;

    public static void init(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    /**
     * 获取Boolean
     */
    public static void setBoolean(String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    /**
     * 获取Boolean
     *
     * @param key
     * @param value
     */
    public static Boolean getBoolean(String key, boolean value) {
        return mSharedPreferences.getBoolean(key, value);
    }

    /**
     * 获取String
     */
    public static String getString(String key, String defValue) {
        return mSharedPreferences.getString(key, defValue);
    }

    /**
     * 设置String
     */
    public static void setString(String key, String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    /**
     * 获取Int
     */
    public static int getInt(String key, int defValue) {
        return mSharedPreferences.getInt(key, defValue);
    }

    /**
     * 设置Int
     */
    public static void setInt(String key, int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    /**
     * 获取Long
     */
    public static long getLong(String key, long defValue) {
        return mSharedPreferences.getLong(key, defValue);
    }

    /**
     * 设置Long
     */
    public static void setLong(String key, long value) {
        mSharedPreferences.edit().putLong(key, value).apply();
    }

    /**
     * 获取token
     *
     * @return
     */
    public static String getToken() {
        return mSharedPreferences.getString(AppConstants.SP.TOKEN, "");
    }

    /**
     * 设置token
     *
     * @param token
     */
    public static void setToken(String token) {
        mSharedPreferences.edit().putString(AppConstants.SP.TOKEN, token).apply();
    }

    /**
     * 移除指定key的信息
     */
    public static void clear(String key) {
        mSharedPreferences.edit().remove(key).apply();
    }


    /**
     * 移除所有信息
     */
    public static void clearAll() {
        mSharedPreferences.edit().clear().apply();
    }


}
