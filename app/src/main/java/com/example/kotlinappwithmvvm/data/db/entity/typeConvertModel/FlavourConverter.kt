package com.example.kotlinappwithmvvm.data.db.entity.typeConvertModel

import androidx.room.TypeConverter
import com.example.kotlinappwithmvvm.data.db.entity.Flavour
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class FlavourConverter {

    @TypeConverter
    fun fromFlavourList(value: List<Flavour>): String {
        val gson = Gson()
        val type = object : TypeToken<List<Flavour>>() {}.type
        return gson.toJson(value, type)
    }

    @TypeConverter
    fun toFlavourList(value: String): List<Flavour> {
        val gson = Gson()
        val type = object : TypeToken<List<Flavour>>() {}.type
        return gson.fromJson(value, type)
    }

}