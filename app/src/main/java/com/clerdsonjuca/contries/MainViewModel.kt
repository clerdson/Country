package com.clerdsonjuca.contries

import android.app.Application
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * MvvM com Corrotines e Retrofit
 * */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,

):ViewModel() {
    private val _response:MutableLiveData<NetworkResult<List<Country>>> = MutableLiveData()
    val response:LiveData<NetworkResult<List<Country>>> = _response

    fun fetchContries() = viewModelScope.launch {
        repository.getContry().collect {
            _response.value = it
        }
    }

//    var items = MutableLiveData<List<Country>>()
//
//    fun fethcCountries(){
//        viewModelScope.launch(Dispatchers.IO) {
//           val response = repository.getContry()
//            items.postValue(response.body())
//        }
//    }

}