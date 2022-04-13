package com.clerdsonjuca.contries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
/**
 * MvvM com Corrotines e Retrofit
 * */
class MainViewModel:ViewModel() {
    private val sevice = CountryService()
    private val _items = MutableLiveData<List<Country>>()
    val items:LiveData<List<Country>>
    get() = _items
    fun fethcCountries(){
        viewModelScope.launch(Dispatchers.IO) {
            val res = sevice.getCountries()
            if (res.isSuccessful){
                _items.postValue(res.body())
            }
        }
    }
}