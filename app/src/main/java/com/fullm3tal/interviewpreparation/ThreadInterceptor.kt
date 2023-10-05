package com.fullm3tal.interviewpreparation

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class ThreadInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response = chain.run {
        Log.v(TAG, "Intercept: " + Thread.currentThread().name + " " + Thread.currentThread().id)
        proceed(
            request().newBuilder().build()
        )
    }
}