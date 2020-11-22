package com.example.imagesearchapp.application

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.example.imagesearchapp.base.ApplicationComponent
import com.example.imagesearchapp.base.DaggerApplicationComponent
import com.example.imagesearchapp.di.modules.ApplicationModule
import com.example.imagesearchapp.network.NetworkService
import com.example.imagesearchapp.rx.SchedulerProvider
import com.example.imagesearchapp.utils.LoadingDialog
import javax.inject.Inject

class ImageSearchApplication : Application() ,
    Application.ActivityLifecycleCallbacks {

    var applicationComponent: ApplicationComponent? = null
    @Inject
    lateinit var networkService: NetworkService

    @Inject
    lateinit var schedulerProvider: SchedulerProvider

    private val isConnected = false

    override fun onCreate() {
        super.onCreate()

        // Register Application Life Cycle.
        registerActivityLifecycleCallbacks(this)

        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent!!.inject(this)

    }

    override fun onActivityPaused(activity: Activity) {
        LoadingDialog.unbind()
    }

    override fun onActivityStarted(activity: Activity) {
    }

    override fun onActivityDestroyed(activity: Activity) {
    }

    override fun onActivitySaveInstanceState(activity: Activity, p1: Bundle) {
    }

    override fun onActivityStopped(activity: Activity) {
    }

    override fun onActivityCreated(activity: Activity, p1: Bundle?) {
    }

    override fun onActivityResumed(activity: Activity) {
        LoadingDialog.bindWith(activity)
    }

    fun getConnectionStatus(): Boolean {
        return isConnected
    }
}