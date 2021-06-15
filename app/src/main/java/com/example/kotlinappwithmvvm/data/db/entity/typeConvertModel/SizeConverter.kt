package com.example.kotlinappwithmvvm.data.db.entity.typeConvertModel

import androidx.room.TypeConverter
import com.example.kotlinappwithmvvm.data.db.entity.Flavour
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SizeConverter {
    @TypeConverter
    fun fromSizeList(value: List<Any>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Any>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toSizeList(value: String): List<Any> {
        val gson = Gson()
        val type = object : TypeToken<List<Any>>() {}.type
        return gson.fromJson(value, type)
    }
}