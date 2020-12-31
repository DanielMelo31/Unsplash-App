package com.example.imagesearchapp.di

import com.example.imagesearchapp.domain.UnsplashService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitClient(): Retrofit =
        Retrofit.Builder()
            .baseUrl(UnsplashService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun provideUnsplashService(retrofit:Retrofit): UnsplashService =
        retrofit.create(UnsplashService::class.java)
}