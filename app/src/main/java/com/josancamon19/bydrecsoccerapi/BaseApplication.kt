package com.josancamon19.bydrecsoccerapi

import com.josancamon19.bydrecsoccerapi.di.app.DaggerAppComponent
import dagger.android.support.DaggerApplication
import timber.log.Timber

class BaseApplication : DaggerApplication() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun applicationInjector() = DaggerAppComponent.builder().application(this).build()


}