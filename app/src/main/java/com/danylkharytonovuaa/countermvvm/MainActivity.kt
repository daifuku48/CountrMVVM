package com.danylkharytonovuaa.countermvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.danylkharytonovuaa.countermvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var binding : ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val viewModelFactory = MainViewModelFactory(125)
        val vm = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]

        vm.currentCount.observe(this, Observer<Int>{
            binding?.counterTextView?.text = it.toString()
        })

        binding?.plusButton?.setOnClickListener {
            vm.plus()
        }

        binding?.minusButton?.setOnClickListener {
            vm.minus()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}