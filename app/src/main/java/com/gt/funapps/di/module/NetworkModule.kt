package com.gt.funapps.di.module

import com.gt.data.datasource.remote.api.SocialChannelService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton
import okhttp3.logging.HttpLoggingInterceptor


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor) = OkHttpClient.Builder()
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideApiInterface(retrofit: Retrofit) =
        retrofit.create(SocialChannelService::class.java)

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor
    }
}