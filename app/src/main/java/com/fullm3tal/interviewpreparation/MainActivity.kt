package com.fullm3tal.interviewpreparation

import android.content.Intent
import android.os.Bundle
import com.fullm3tal.interviewpreparation.databinding.ActivityMainBinding


class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSet.setOnClickListener {
           startActivity(Intent(this, NextActivity::class.java))
        }
    }

}