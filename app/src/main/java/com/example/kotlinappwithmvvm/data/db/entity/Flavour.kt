package com.example.kotlinappwithmvvm.data.db.entity

data class Flavour(
    val id: Int,
    val size: List<Size>,
    val title: String
)