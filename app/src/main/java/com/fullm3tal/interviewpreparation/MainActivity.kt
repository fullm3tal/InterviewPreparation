package com.fullm3tal.interviewpreparation

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.fullm3tal.interviewpreparation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val columns =
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) 5 else 4
        val layoutManager = GridLayoutManager(this, columns)
        binding.rv.layoutManager = layoutManager
        binding.rv.adapter = ListAdapter(
            listOf(
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
                "Hello",
            )
        )
    }

}

