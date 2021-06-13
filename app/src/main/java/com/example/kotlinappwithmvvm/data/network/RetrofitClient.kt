package com.example.kotlinappwithmvvm.data.network

import android.content.Context
import com.example.kotlinappwithmvvm.data.network.ApiConstant.Companion.BASE_URL
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import com.example.kotlinappwithmvvm.BuildConfig

class RetrofitClient @Inject constructor() {
/*simplied coding*/

    fun <Api> buildApi(
        api: Class<Api>,
        context: Context
    ): Api {

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder().also { client ->
                    if (BuildConfig.DEBUG) {
                        val logging = HttpLoggingInterceptor()
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                        client.addInterceptor(logging)
                    }
                }.build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)
    }



    /*return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addInterceptor { chain ->
                chain.proceed(
                    chain.request.newBuilder().also {
                        it.addHeader("Authorization", "Token"$token)
                    }.build()
                )
            }
            .client(
                OkHttpCLient.Builder().also { client ->
                    if (BuildConfig.DEBUG) {
                        val logging = HttpLoggingInterceptor()
                        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                        client.addInterceptor(logging)
                    }
                }.build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)*/




    /*private val loggingInterceptor = HttpLoggingInterceptor().apply {
        this.level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder().apply {
        addNetworkInterceptor(loggingInterceptor)
        readTimeout(60, TimeUnit.SECONDS)
        connectTimeout(60, TimeUnit.SECONDS)
        writeTimeout(60, TimeUnit.SECONDS)
    }.build()

    private val retrofitBuilder: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
    }

    val apiService: ApiInterface by lazy {
        retrofitBuilder
            .build()
            .create(ApiInterface::class.java)
    }*/


}