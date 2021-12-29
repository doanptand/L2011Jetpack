package com.ddona.l2011jetpack.vm

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MusicViewModel(
    val app: Application,
    var tempNumber: Int
) : ViewModel() {
    private val _number = MutableLiveData<Int>()
    val number: LiveData<Int>
        get() = _number

    init {
        _number.postValue(0)
    }

    fun increaseNumber() {
        _number.postValue(number.value?.plus(1))
    }

}