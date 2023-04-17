package com.danylkharytonovuaa.countermvvm

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory

class MainViewModel(
    private val startCount: Int
) : ViewModel() {

    val currentCount: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    private var count = 0

    init {
        count = startCount
    }

    fun plus() {
        count++
        currentCount.value = count
    }

    fun minus()
    {
        count--
        currentCount.value = count
    }

    fun getValue() : MutableLiveData<Int> {
        currentCount.value = count
        return currentCount
    }
}