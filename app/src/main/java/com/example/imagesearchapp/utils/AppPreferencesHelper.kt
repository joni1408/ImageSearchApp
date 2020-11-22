package com.example.imagesearchapp.utils

import android.content.Context
import android.content.SharedPreferences

class AppPreferencesHelper private constructor(context: Context) :
    PreferencesHelper {
    private val mPrefs: SharedPreferences?
    private val prefName = "imageLoader"


    companion object {
        private lateinit var appPreferencesHelper: AppPreferencesHelper
        fun getInstance(context: Context): AppPreferencesHelper {
            if (!this::appPreferencesHelper.isInitialized) {
                appPreferencesHelper = AppPreferencesHelper(context)
            }
            return appPreferencesHelper
        }
    }


    init {
        mPrefs = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }


    override var userId: String?
        get() = mPrefs?.getString(AppConstants.PREFERENCE_KEY.USER_ID, null)
        set(userId) {
            mPrefs?.edit()?.putString(AppConstants.PREFERENCE_KEY.USER_ID, userId)?.apply()
        }

    override fun clearSharedPreferences() {
        if (mPrefs != null) {
            val editor = mPrefs.edit()
            editor.clear()
            editor.apply()
        }
    }

    override fun storeToken(token: String?) {
        mPrefs?.edit()?.putString(AppConstants.PREFERENCE_KEY.TOKEN_KEY, token)?.apply()
    }

    override val token: String?
        get() = mPrefs?.getString(AppConstants.PREFERENCE_KEY.TOKEN_KEY, "")

}
