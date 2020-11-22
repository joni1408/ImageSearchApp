package com.example.imagesearchapp.base

import android.app.Application
import android.content.Context
import com.example.imagesearchapp.application.ImageSearchApplication
import com.example.imagesearchapp.di.ApplicationContext
import com.example.imagesearchapp.di.modules.ApplicationModule
import com.example.imagesearchapp.network.NetworkService
import com.example.imagesearchapp.rx.SchedulerProvider
import com.example.imagesearchapp.utils.NetworkHelper
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: ImageSearchApplication)

    fun getApplication(): Application

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getNetworkHelper(): NetworkHelper

    fun getSchedulerProvider(): SchedulerProvider

    fun getCompositeDisposable(): CompositeDisposable

}