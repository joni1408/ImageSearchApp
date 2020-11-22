package com.example.imagesearchapp.network

import android.content.Context
import com.example.imagesearchapp.BuildConfig
import com.example.imagesearchapp.network.eventHandler.EventBus
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

open class ImageLoaderService {
    protected var context: Context?
    protected var eventBus: EventBus? = null
    protected var retrofit: Retrofit
    protected var clientBuilder: OkHttpClient.Builder
    protected var objectMapper: ObjectMapper

    constructor(context: Context, eventBus: EventBus?) {
        this.context = context
        this.eventBus = eventBus
        clientBuilder = OkHttpClient.Builder()
        clientBuilder.connectTimeout(30, TimeUnit.SECONDS)
        clientBuilder.readTimeout(10, TimeUnit.MINUTES)
        clientBuilder.writeTimeout(10, TimeUnit.MINUTES)
        val tokenAuthenticator = TokenAuthenticator()
        clientBuilder.addInterceptor(tokenAuthenticator)
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        clientBuilder.addInterceptor(httpLoggingInterceptor)
        objectMapper = ObjectMapper()
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
        objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
        retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(clientBuilder.build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            /**
             * A ScalarsConverterFactory for strings and both primitives and their boxed types
             * to text/plain bodies.
             */
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(JacksonConverterFactory.create(objectMapper))
            .build()
    }
}
