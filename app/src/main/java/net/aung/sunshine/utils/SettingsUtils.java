package net.aung.sunshine.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import net.aung.sunshine.R;
import net.aung.sunshine.SunshineApplication;

import java.util.Locale;

/**
 * Created by aung on 2/7/16.
 */
public class SettingsUtils {

    public static final int ICON_PACK_DEFAULT = 0;
    public static final int ICON_PACK_UDACITY = 1;

    public static final int LANG_ENG = 0;
    public static final int LANG_MM = 1;

    /**
     * Retrieve the city name that user set in Settings
     *
     * @return city name
     */
    public static String retrieveUserCity() {
        Context context = SunshineApplication.getContext();
        SharedPreferences defaultSharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String userLocation = defaultSharedPref.getString(context.getString(R.string.pref_location_key), "your current city"); //TODO remove Rangoon & set null.

        return userLocation;
    }

    /**
     * @return
     */
    public static String retrieveSelectedUnit() {
        Context context = SunshineApplication.getContext();
        SharedPreferences defaultSharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        return defaultSharedPref.getString(context.getString(R.string.pref_unit_key), context.getString(R.string.pref_unit_metric)); //return "metrics" if user hasn't pick any unit yet.
    }

    public static void saveUserCity(String newCity) {
        Context context = SunshineApplication.getContext();
        SharedPreferences defaultSharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPref.edit().putString(context.getString(R.string.pref_location_key), newCity).apply();
    }

    public static boolean retrieveNotificationPref() {
        Context context = SunshineApplication.getContext();
        SharedPreferences defaultSharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        return defaultSharedPref.getBoolean(context.getString(R.string.pref_enable_notification_key), true);
    }

    public static void saveNotificationPref(boolean newPref) {
        Context context = SunshineApplication.getContext();
        SharedPreferences defaultSharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPref.edit().putBoolean(context.getString(R.string.pref_enable_notification_key), newPref).apply();
    }

    public static void saveServerResponseStatus(@SunshineConstants.ServerStatus int status) {
        Context context = SunshineApplication.getContext();
        SharedPreferences defaultSharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        defaultSharedPref.edit().putInt(context.getString(R.string.pref_server_response_status_key), status).apply();
    }

    public static int getServerResponseStatus() {
        Context context = SunshineApplication.getContext();
        SharedPreferences defaultSharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        return defaultSharedPref.getInt(context.getString(R.string.pref_server_response_status_key), SunshineConstants.STATUS_SERVER_UNKNOWN);
    }

    public static int retrieveIconPackPref() {
        Context context = SunshineApplication.getContext();
        SharedPreferences defaultSharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String iconPackPref = defaultSharedPref.getString(context.getString(R.string.pref_icon_key), "");

        if (iconPackPref.equals(context.getString(R.string.pref_icon_pack_udacity))) {
            return ICON_PACK_UDACITY;
        }

        return ICON_PACK_DEFAULT;
    }

    public static int retrieveLanguagePref() {
        Context context = SunshineApplication.getContext();
        SharedPreferences defaultSharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String langPref = defaultSharedPref.getString(context.getString(R.string.pref_language_key), "");

        if (langPref.equals(context.getString(R.string.pref_language_myanmar))) {
            return LANG_MM;
        }

        return LANG_ENG;
    }

    public static Locale getLocale() {
        Context context = SunshineApplication.getContext();
        SharedPreferences defaultSharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String langPref = defaultSharedPref.getString(context.getString(R.string.pref_language_key), "");

        if (langPref.equals(context.getString(R.string.pref_language_myanmar))) {
            return new Locale("my");
        }

        return new Locale("en");
    }
}
