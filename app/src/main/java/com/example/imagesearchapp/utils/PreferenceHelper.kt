package com.example.imagesearchapp.utils

interface PreferencesHelper {
    var userId: String?

    fun clearSharedPreferences()
    fun storeToken(token: String?)
    val token: String?
}
