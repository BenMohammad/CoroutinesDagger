package com.benmohammad.coroutinesdagger.di

import com.benmohammad.coroutinesdagger.domain.GithubRepo
import com.benmohammad.coroutinesdagger.repository.GithubApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

private const val GITHUB_BASE_URL = "https://api.github.com/"

@Module
class NetworkModule {

    @Provides
    fun provideRetrofit(): GithubApi {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpBuilder = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)

        return Retrofit.Builder()
            .baseUrl(GITHUB_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpBuilder.build())
            .build()
            .create(GithubApi::class.java)
    }
}