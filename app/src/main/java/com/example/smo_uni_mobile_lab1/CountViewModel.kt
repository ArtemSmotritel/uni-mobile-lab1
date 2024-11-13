package com.example.smo_uni_mobile_lab1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountViewModel : ViewModel() {
    private val _count = MutableLiveData<Int>(0)
    val count: LiveData<Int> = _count

    fun increaseCount() {
        _count.value = _count.value?.inc()
    }
}