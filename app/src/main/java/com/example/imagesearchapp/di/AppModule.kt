package com.example.imagesearchapp.di

import com.example.imagesearchapp.domain.UnsplashService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {


    fun provideRetrofitClient(): Retrofit =
        Retrofit.Builder()
            .baseUrl(UnsplashService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}