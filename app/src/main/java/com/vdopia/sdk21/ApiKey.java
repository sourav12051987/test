package com.vdopia.sdk21;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;

/**
 * Api Keys
 *
 * @author Vdopia Team
 */
@SuppressWarnings("unused")
public final class ApiKey {

    private static final String TAG = "Apikey";

    public static final String VDOPIA_PREF = "Vdopia_Prefs";

    public static final String CHANNEL_ID = "ChannelID";
    static String API_KEY_COMMON = "857f28fcdcc0e4c7a8fffa5145f1a27e";

    public static final String FACEBOOK_HASH_ID_KEY = "FacebookHashID";
    static String FACEBOOK_HASH_ID_VALUE = "";

    public static final String YAHOO_TEST_ID_KEY = "YahooTestID";
    static boolean YAHOO_TEST_ID_VALUE = false;

    public static String getApiKeyCommon(Activity mActivity) {
        SharedPreferences mSharedPreferences = mActivity.getApplicationContext().getSharedPreferences(VDOPIA_PREF, Context.MODE_PRIVATE);
        String apiKey = mSharedPreferences.getString(CHANNEL_ID, ApiKey.API_KEY_COMMON);
        if (apiKey != null && !apiKey.isEmpty()) {
            ApiKey.API_KEY_COMMON = apiKey;
        }
        Log.d(TAG, "API_KEY_COMMON..." + ApiKey.API_KEY_COMMON);
        return ApiKey.API_KEY_COMMON;
    }

    public static String getFacebookHashID(Activity mActivity) {
        SharedPreferences mSharedPreferences = mActivity.getApplicationContext().getSharedPreferences(VDOPIA_PREF, Context.MODE_PRIVATE);
        String hashID = mSharedPreferences.getString(FACEBOOK_HASH_ID_KEY, ApiKey.FACEBOOK_HASH_ID_VALUE);
        if (!TextUtils.isEmpty(hashID)) {
            ApiKey.FACEBOOK_HASH_ID_VALUE = hashID;
        }
        Log.d(TAG, "FACEBOOK_HASH_ID..." + ApiKey.FACEBOOK_HASH_ID_VALUE);
        return ApiKey.FACEBOOK_HASH_ID_VALUE;
    }

    public static boolean getYahooTestMode(Activity mActivity) {
        SharedPreferences mSharedPreferences = mActivity.getApplicationContext().getSharedPreferences(VDOPIA_PREF, Context.MODE_PRIVATE);
        ApiKey.YAHOO_TEST_ID_VALUE = mSharedPreferences.getBoolean(YAHOO_TEST_ID_KEY, ApiKey.YAHOO_TEST_ID_VALUE);
        Log.d(TAG, "YAHOO_TEST_ID_VALUE..." + ApiKey.FACEBOOK_HASH_ID_VALUE);
        return ApiKey.YAHOO_TEST_ID_VALUE;
    }
}
