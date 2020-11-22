package com.example.imagesearchapp.di.modules

import android.app.Application
import android.content.Context
import com.example.imagesearchapp.BuildConfig
import com.example.imagesearchapp.application.ImageSearchApplication
import com.example.imagesearchapp.di.ApplicationContext
import com.example.imagesearchapp.network.NetworkService
import com.example.imagesearchapp.network.Networking
import com.example.imagesearchapp.rx.RxSchedulerProvider
import com.example.imagesearchapp.rx.SchedulerProvider
import com.example.imagesearchapp.utils.NetworkHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class ApplicationModule(private val application: ImageSearchApplication) {

    @Provides
    @Singleton
    fun provideApplication(): Application = application

    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(): Context = application

    /**
     * Since this function do not have @Singleton then each time CompositeDisposable is injected
     * then a new instance of CompositeDisposable will be provided
     */
    @Provides
    fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkService =
        Networking.create(
            "",
            BuildConfig.BASE_URL,
            application.cacheDir,
            10 * 1024 * 1024,//10mb
            application
        )

    @Singleton
    @Provides
    fun provideNetworkHelper(): NetworkHelper = NetworkHelper(application)

}