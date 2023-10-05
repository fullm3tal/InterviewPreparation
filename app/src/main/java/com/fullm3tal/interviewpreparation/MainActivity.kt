package com.fullm3tal.interviewpreparation

import android.os.Bundle
import com.fullm3tal.interviewpreparation.databinding.ActivityMainBinding


class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSet.setOnClickListener {
            val value: String = binding.tvUseText.text.toString()
            binding.tvData.text = value
        }
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putString("saved", binding.tvData.text.toString())
//    }
//
//    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
//        super.onRestoreInstanceState(savedInstanceState)
//        val savedString = savedInstanceState.getString("saved")
//        binding.tvData.text = savedString
//    }

}