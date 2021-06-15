package com.example.kotlinappwithmvvm.data.repositories

import androidx.lifecycle.LiveData
import androidx.room.Insert
import com.example.kotlinappwithmvvm.data.db.Dao
import com.example.kotlinappwithmvvm.data.db.entity.Product
import com.example.kotlinappwithmvvm.data.network.ApiInterface
import com.example.kotlinappwithmvvm.data.network.Resource
import com.example.kotlinappwithmvvm.data.network.model.SubCategoryCakesResponse
import com.example.kotlinappwithmvvm.utilities.SafeApiRequest
import javax.inject.Inject

/**
 * In this Repository class we define retrofit calls
 * You can inject retrofit client and database class here, so no need to create object of this
 * class again and again
 *
 * */


class Repository @Inject constructor(
    private val api: ApiInterface,
    private val dao: Dao
) : SafeApiRequest() {


    suspend fun getCakeList(cakeID: String) =
        safeApiCall {
            api.getCakeList(cakeID)
        }


    suspend fun getCakeList(): LiveData<List<Product>> {
        return dao.getCakeList();
    }

    suspend fun insertCakeList(list: List<Product>) {
        dao.insertCakesList(list)
    }


    /**For offline support ref:developer.android.com*/
    /*fun getUser(userId: String): Flow<User> {
       refreshUser(userId)
       // Returns a Flow object directly from the database.
       return userDao.load(userId)
   }

   private suspend fun refreshUser(userId: String) {
       // Check if user data was fetched recently.
       val userExists = userDao.hasUser(FRESH_TIMEOUT)
       if (!userExists) {
           // Refreshes the data.
           val response = webservice.getUser(userId)

           // Check for errors here.

           // Updates the database. Since `userDao.load()` returns an object of
           // `Flow<User>`, a new `User` object is emitted every time there's a
           // change in the `User`  table.
           userDao.save(response.body()!!)
       }
   }

   companion object {
       val FRESH_TIMEOUT = TimeUnit.DAYS.toMillis(1)
   }*/




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