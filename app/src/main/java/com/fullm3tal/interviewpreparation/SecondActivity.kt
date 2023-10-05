package com.fullm3tal.interviewpreparation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.ref.WeakReference

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        SingletonClassWithoutLeak.singletonClassInstance(WeakReference(this))
    }
}