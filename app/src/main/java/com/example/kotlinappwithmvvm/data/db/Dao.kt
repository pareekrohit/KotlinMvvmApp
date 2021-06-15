package com.example.kotlinappwithmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.kotlinappwithmvvm.data.db.entity.Product

@Dao
interface Dao {

    @Insert
    suspend fun insertCakesList(list: List<Product>)

    @Query("SELECT * FROM Product")
    fun getCakeList(): LiveData<List<Product>>

    @Query("SELECT * FROM Product WHERE id=:id")
    fun getSingleCake(id: String): LiveData<Product>


    /*@Insert
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)*/

}