package com.benmohammad.coroutinesdagger

import android.app.Application
import com.benmohammad.coroutinesdagger.di.AppComponent
import com.benmohammad.coroutinesdagger.di.DaggerAppComponent
import timber.log.Timber

class CoroutinesDaggerApp : Application() {

    lateinit var appComponent: AppComponent
    private set

    override fun onCreate() {
        super.onCreate()
        if(BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        appComponent = DaggerAppComponent.factory().create(this)
    }
}