package com.example.kotlinappwithmvvm.ui.activity.cakeList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinappwithmvvm.data.network.model.Product
import com.example.kotlinappwithmvvm.data.repositories.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.kotlinappwithmvvm.data.network.Resource
import com.example.kotlinappwithmvvm.data.network.model.SubCategoryCakesResponse

/**
 * 1)Use ViewModel in activity as ViewModelProvider(this).get(CakeListViewModel::Class.java)
 * If need to pass the parameters to ViewModel then Create ViewModelFactory class and pass the data to it
 * And factory class pass the data to viewModel class
 *
 * 2)For LiveData-> First create MutableLiveData<List<Product>> object and keep on setting the logic to it
 * when you need to pass this object of MutableLiveData to activity then create function which will return LiveData Object
 * shown below in example.
 * Don't use ViewModelProviders class(deprecated)
 *
 * */

@HiltViewModel
class CakeListViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    /*Simplied coding*/

    private val _cakeList: MutableLiveData<Resource<SubCategoryCakesResponse>> = MutableLiveData()
    val cakeList: LiveData<Resource<SubCategoryCakesResponse>>
        get() = _cakeList


    fun getCakeList(
        cakeID: String
    ) = viewModelScope.launch {
        _cakeList.value = Resource.Loading
        _cakeList.value = repository.getCakeList(cakeID)
    }




    /*suspend fun saveAccessTokens(accessToken: String, refreshToken: String) {
        repository.saveAccessTokens(accessToken, refreshToken)
    }*/


}