package com.example.kotlinappwithmvvm.data.network

import com.example.kotlinappwithmvvm.data.network.model.SubCategoryCakesResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface ApiInterface {

    @GET(ApiConstant.CAKE_LIST_ENDPOINT)
    suspend fun getCakeList(
        @Query("category_id") categoryID: String
    ): SubCategoryCakesResponse


    @GET(ApiConstant.LOGIN_ENDPOINT)
    suspend fun login(@Body map: HashMap<String, Any>): SubCategoryCakesResponse


}