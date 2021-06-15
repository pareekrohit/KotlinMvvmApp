package com.example.kotlinappwithmvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.kotlinappwithmvvm.data.db.entity.Product
import com.example.kotlinappwithmvvm.data.db.entity.typeConvertModel.FlavourConverter
import com.example.kotlinappwithmvvm.data.db.entity.typeConvertModel.SizeConverter

@Database(entities = [Product::class], version = 1)
@TypeConverters(FlavourConverter::class, SizeConverter::class)
abstract class AppDB : RoomDatabase() {

    abstract fun getDao(): Dao

    companion object {
        @Volatile
        private var INSTANCE: AppDB? = null
        fun getDatabase(context: Context): AppDB {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        AppDB::class.java,
                        "Cakes_app_database"
                    )
                        .build()
                }
            }
            return INSTANCE!!
        }
    }

}