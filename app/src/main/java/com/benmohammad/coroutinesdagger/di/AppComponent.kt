package com.benmohammad.coroutinesdagger.di

import android.app.Application
import com.benmohammad.coroutinesdagger.views.ReposFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, ViewModelModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    fun inject(fragment: ReposFragment)
}