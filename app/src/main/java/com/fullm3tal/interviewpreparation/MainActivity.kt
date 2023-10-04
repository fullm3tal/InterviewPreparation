package com.fullm3tal.interviewpreparation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.fullm3tal.interviewpreparation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.tvCallable.setOnClickListener {
            RxObservableJava.singleCallable()
        }

        binding.tvJust.setOnClickListener {
            RxObservableJava.single()
        }
    }

}