package com.example.kotlinappwithmvvm.data.network.model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class SubCategoryCakesResponse(
    val cart_item_count: String,
    val products: List<Product>
)