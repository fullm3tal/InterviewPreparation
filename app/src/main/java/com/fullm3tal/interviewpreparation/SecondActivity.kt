package com.fullm3tal.interviewpreparation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fullm3tal.interviewpreparation.databinding.ActivitySecondBinding
import com.fullm3tal.interviewpreparation.model.LaunchInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.concurrent.thread

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding
    lateinit var thread: Thread
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSecond.setOnClickListener {
            fetchResponseExecute()
        }
    }

    private fun fetchResponseEnqueue() {
        RetrofitInstance().service.fetchLaunchList()
            .enqueue(object : Callback<ArrayList<LaunchInfo>> {
                override fun onResponse(
                    call: Call<ArrayList<LaunchInfo>>, response: Response<ArrayList<LaunchInfo>>
                ) {
                    Log.v(TAG, "OnSuccess: " + Thread.currentThread().name)
                    if (response.isSuccessful && response.body() != null) {
                        Log.v(TAG, "OnSuccess: " + response.body()?.size.toString())
//                        binding.tvData.text = response.body()?.size.toString()
                    }
                }

                override fun onFailure(call: Call<ArrayList<LaunchInfo>>, t: Throwable) {
                    Log.v(TAG, "OnFailure: " + Thread.currentThread().name + t)
//                    binding.tvData.text = "Something Went wrong"
                }
            })
    }

    private fun fetchResponseExecute() {
        try {
            thread = Thread {
                val response = RetrofitInstance().service.fetchLaunchList().execute()
                response.runCatching {
                    runOnUiThread {
                        Log.v(TAG, "OnSuccess: " + Thread.currentThread().name)
                        if (response.isSuccessful && response.body() != null) {
//                        binding.tvData.text = response.body()?.size.toString()
                            Log.v(TAG, "OnSuccess: " + response.body()?.size.toString())
                        }
                    }
                }.onFailure {
                    Log.v(TAG, "OnFailure: " + Thread.currentThread().name + it.message.toString())
//                binding.tvData.text = "Something Went wrong"
                }
            }
        } catch (e: InterruptedException) {
            println("Thread interrupted")
        }
        thread.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (thread.isAlive) {
            thread.interrupt()
        }
    }

}