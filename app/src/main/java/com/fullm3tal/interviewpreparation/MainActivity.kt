package com.fullm3tal.interviewpreparation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.fullm3tal.interviewpreparation.databinding.ActivityMainBinding

const val TAG = "MainActivityPrep"

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.tvData.text = "Hello World"
        viewModel.launchListResponseLiveData.observe(this) {
            if (it.list.isNotEmpty()) {
                binding.tvData.text = it.list.size.toString()
            }
        }
    }
}