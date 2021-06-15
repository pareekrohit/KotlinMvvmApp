package com.example.kotlinappwithmvvm.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
    @PrimaryKey
    val id: Int,

    val category_id: Int,
    val category_name: String = "",
    val delivery_care: String = "",
    val delivery_time: String = "",
    val description: String = "",
    val discount_percent: String = "",
    val flavour: List<Flavour>,
    val image: String = "",
    val is_favourite: Boolean,
    val is_veg: Boolean,
    val name: String = "",
    val price: String = "",
    val size: List<Any>
)