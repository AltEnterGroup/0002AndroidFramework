package cn.cloudwalk.libs.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import cn.cloudwalk.libs.data.SecuritySharedPreference;

/**
 * ClassName:SecurityPreferencesUtils <br/>
 * Description:  Preferences加密存储. <br/>
 * Date:     2017年02月03日 15:39 <br/>
 *
 * @author 284891377
 * @since JDK 1.7
 */
public class SecurityPreferencesUtils {


    public static boolean putString(Context context, String key, String value) {
        SecuritySharedPreference settings = new SecuritySharedPreference(context, "", Context.MODE_PRIVATE);
        SecuritySharedPreference.SecurityEditor editor = settings.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public static String getString(Context context, String key) {
        SecuritySharedPreference settings = new SecuritySharedPreference(context, "", Context.MODE_PRIVATE);
        return settings.getString(key, null);
    }

    public static String getString(Context context, String key, String defaultValue) {
        SecuritySharedPreference settings = new SecuritySharedPreference(context, "", Context.MODE_PRIVATE);
        return settings.getString(key, defaultValue);
    }

    //
    public static boolean putLong(Context context, String key, long value) {
        SecuritySharedPreference settings = new SecuritySharedPreference(context, "", Context.MODE_PRIVATE);
        SecuritySharedPreference.SecurityEditor editor = settings.edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    public static boolean putFloat(Context context, String key, float value) {
        SecuritySharedPreference settings = new SecuritySharedPreference(context, "", Context.MODE_PRIVATE);
        SecuritySharedPreference.SecurityEditor editor = settings.edit();
        editor.putFloat(key, value);
        return editor.commit();
    }

    public static boolean putInt(Context context, String key, int value) {
        SecuritySharedPreference settings = new SecuritySharedPreference(context, "", Context.MODE_PRIVATE);
        SecuritySharedPreference.SecurityEditor editor = settings.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    public static boolean putBoolean(Context context, String key, boolean value) {
        SecuritySharedPreference settings = new SecuritySharedPreference(context, "", Context.MODE_PRIVATE);
        SecuritySharedPreference.SecurityEditor editor = settings.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    public static long getLong(Context context, String key) {
        return getLong(context, key, -1);
    }


    public static int getInt(Context context, String key, int defaultValue) {
        SecuritySharedPreference settings = new SecuritySharedPreference(context, "", Context.MODE_PRIVATE);
        return settings.getInt(key, defaultValue);
    }

    public static float getFloat(Context context, String key, float defaultValue) {
        SecuritySharedPreference settings = new SecuritySharedPreference(context, "", Context.MODE_PRIVATE);
        return settings.getFloat(key, defaultValue);
    }

    public static long getLong(Context context, String key, long defaultValue) {
        SecuritySharedPreference settings = new SecuritySharedPreference(context, "", Context.MODE_PRIVATE);
        return settings.getLong(key, defaultValue);
    }

    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        SecuritySharedPreference settings = new SecuritySharedPreference(context, "", Context.MODE_PRIVATE);
        return settings.getBoolean(key, defaultValue);
    }


    public static boolean removeSharedPreferenceByKey(Context context, String key) {
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = settings.edit();
        editor.remove(key);
        return editor.commit();
    }
}
