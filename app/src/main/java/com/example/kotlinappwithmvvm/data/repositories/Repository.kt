package com.example.kotlinappwithmvvm.data.repositories

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlinappwithmvvm.data.network.ApiInterface
import com.example.kotlinappwithmvvm.data.network.RetrofitClient
import com.example.kotlinappwithmvvm.data.network.model.Product
import com.example.kotlinappwithmvvm.data.network.model.SubCategoryCakesResponse
import com.example.kotlinappwithmvvm.utilities.SafeApiRequest
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.Job
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Executable
import java.util.*
import javax.inject.Inject

/**
 * In this Repository class we define retrofit calls
 * You can inject retrofit client and database class here, so no need to create object of this
 * class again and again
 *
 * */


class Repository @Inject constructor(
    private val api: ApiInterface
) : SafeApiRequest() {


    suspend fun getCakeList(cakeID: String): SubCategoryCakesResponse {
        return apiRequest {
            api.getCakeList(cakeID)
        }
    }


    /*
    suspend fun userLogin(
        name: String,
        email: String,
        password: String
    ): SubCategoryCakesResponse = apiRequest {
    api.login()
    }
    */



    /*
    suspend fun saveAccessTokens(accessToken: String, refreshToken: String) {
        preferences.saveAccessTokens(accessToken, refreshToken)
    }*/



}