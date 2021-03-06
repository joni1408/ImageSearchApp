package com.example.imagesearchapp.network

import com.example.imagesearchapp.utils.AppConstants
import okhttp3.*
import java.io.IOException

class TokenAuthenticator : Interceptor, Authenticator {

    /**
     * Interceptor class for setting of the headers for every request
     */
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build()
        return chain.proceed(request)
    }

    /**
     * Authenticator for when the authToken need to be refresh and updated
     * everytime we get a 401 error code
     */
    @Throws(IOException::class)
    override fun authenticate(route: Route?, response: Response): Request? {
        var requestAvailable: Request? = null
        try {
            requestAvailable = response.request.newBuilder()
                .addHeader("Authorization", "Client-ID ${AppConstants.Credentials.TOKEN}")
                .build()
            return requestAvailable
        } catch (ex: Exception) {
        }
        return requestAvailable
    }
}