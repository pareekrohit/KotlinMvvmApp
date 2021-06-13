package com.example.kotlinappwithmvvm.di

import android.content.Context
import com.example.kotlinappwithmvvm.data.network.ApiInterface
import com.example.kotlinappwithmvvm.data.network.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideApiInterface(
        @ApplicationContext context: Context,
        retrofitClient: RetrofitClient
    ): ApiInterface {
        return retrofitClient.buildApi(ApiInterface::class.java, context)
    }





}