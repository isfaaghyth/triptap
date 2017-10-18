package hackathon.app.triptap.utils;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import hackathon.app.triptap.App;

/**
 * Created by isfaaghyth on 10/18/17.
 * github: @isfaaghyth
 */

public class CacheManager {
    private static final String TAG = "CacheManager";

    private static SharedPreferences getPref() {
        return PreferenceManager.getDefaultSharedPreferences(App.getContext());
    }

    public static void save(String key, String value) {
        Log.d(TAG, "saveCache: <" + key + ">" + value);
        getPref().edit().putString(key, value).apply();
    }

    public static void save(String key, Boolean value) {
        Log.d(TAG, "saveCache: <" + key + ">" + value);
        getPref().edit().putBoolean(key, value).apply();
    }

    public static Boolean checkExist(String key) {
        return getPref().contains(key);
    }

    public static String grabString(String key) {
        return getPref().getString(key, null);
    }

    public static Boolean grabBoolean(String key) {
        return getPref().getBoolean(key, false);
    }
}
