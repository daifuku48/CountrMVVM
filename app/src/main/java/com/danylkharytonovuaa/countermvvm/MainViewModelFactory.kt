package com.danylkharytonovuaa.countermvvm

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val startingCount : Int) : ViewModelProvider.Factory{

    override fun <T:ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(startingCount) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }
}