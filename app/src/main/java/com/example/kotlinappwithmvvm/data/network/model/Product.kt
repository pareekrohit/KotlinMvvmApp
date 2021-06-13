package com.example.kotlinappwithmvvm.data.network.model

data class Product(
    val category_id: Int,
    val category_name: String,
    val delivery_care: String,
    val delivery_time: String,
    val description: String,
    val discount_percent: String,
    val flavour: List<Flavour>,
    val id: Int,
    val image: String,
    val is_favourite: Boolean,
    val is_veg: Boolean,
    val name: String,
    val price: Any,
    val size: List<Any>
)