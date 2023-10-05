package com.fullm3tal.interviewpreparation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main() {
    val number = 1;
    val data1 = number.let {
        2
    }
    println(data1)
    val data2 = number.run {
        2
    }
    println(data2)
    val data3 = number.apply {
        3
    }
    println(data3)
    val data4 = number.also {
        3
    }
    println(data4)

    val data5 = with(number) {
        3
    }
    println(data5)

}