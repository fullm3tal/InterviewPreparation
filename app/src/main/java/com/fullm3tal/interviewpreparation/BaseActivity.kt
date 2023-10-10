package com.fullm3tal.interviewpreparation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

const val TAG = "InterviewPreparationActivity"


/**
 *  EditText is a focused view, so in PhoneWindow, it's state will be saved automatically in saveHierarchyState() method. You can see the code:
 *
 *   Activity lifecycle on phone rotation
 *
 *   onCreate:
 *   onStart:
 *   onResume:
 *   onPause:
 *   onStop:
 *   onSaveInstanceState:
 *   onDestroy:
 *   onCreate:
 *   onStart:
 *   onRestoreInstanceState:
 *   onResume:
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "${this.localClassName} onCreate: ")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d(TAG, "${this.localClassName} onSaveInstanceState: ")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d(TAG, "${this.localClassName} onRestoreInstanceState: ")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "${this.localClassName} onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "${this.localClassName} onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "${this.localClassName} onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "${this.localClassName} onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "${this.localClassName} onDestroy: ")
    }

}

