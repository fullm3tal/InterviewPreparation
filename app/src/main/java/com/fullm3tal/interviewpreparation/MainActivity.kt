package com.fullm3tal.interviewpreparation

import android.Manifest
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.fullm3tal.interviewpreparation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), 0
            )
        }
        binding.tvStart.setOnClickListener {
            Intent(this, NotificationService::class.java).also {
                it.action = NotificationService.Actions.START.toString()
                startService(it)
            }
        }
        binding.tvStop.setOnClickListener {
            Intent(this, NotificationService::class.java).also {
                it.action = NotificationService.Actions.STOP.toString()
                startService(it)
            }
        }
    }
}