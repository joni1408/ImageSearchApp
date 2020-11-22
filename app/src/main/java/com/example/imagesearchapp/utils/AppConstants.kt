package com.example.imagesearchapp.utils

class AppConstants private constructor() {

    interface Credentials {
        companion object {
            const val TOKEN = "137cda6b5008a7c"
        }
    }

    interface PREFERENCE_KEY {
        companion object {
            const val USER_ID = "userId"
            const val TOKEN_KEY = "token"
        }
    }
}