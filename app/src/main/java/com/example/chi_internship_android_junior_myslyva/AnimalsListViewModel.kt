package com.example.chi_internship_android_junior_myslyva

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class AnimalsListViewModel : ViewModel() {
    private val animalsApi: AnimalsApi = RetrofitHelper.getInstance().create(AnimalsApi::class.java)
    private val _networkResponse = MutableLiveData<List<Animal>>().apply {
        MainScope().launch {
            value = animalsApi.getResponseItem().body()
        }
    }
    val networkResponse: LiveData<List<Animal>> = _networkResponse
}
