package com.ddona.l2011jetpack.vm

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MusicViewModelFactory(
    val app: Application,
    private val tempNumber: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MusicViewModel::class.java)) {
            return MusicViewModel(app, tempNumber) as T
        } else if (modelClass.isAssignableFrom(SampleViewModel::class.java)) {
            return SampleViewModel() as T
        }
        throw IllegalArgumentException("Unknown to create your view model")
    }
}