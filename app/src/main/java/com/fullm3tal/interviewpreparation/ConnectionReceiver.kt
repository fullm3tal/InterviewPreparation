package com.fullm3tal.interviewpreparation

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.util.Log


class ConnectionReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent.action
        if (action != null && action == ConnectivityManager.CONNECTIVITY_ACTION) {
            val connectivityManager =
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val networkInfo = connectivityManager.activeNetworkInfo
            if (networkInfo != null && networkInfo.type == ConnectivityManager.TYPE_WIFI) {
                if (networkInfo.isConnected) {
                    // Wi-Fi is connected
                    Log.d("WifiStateReceiver", "Wi-Fi connected")
                } else {
                    // Wi-Fi is disconnected
                    Log.d("WifiStateReceiver", "Wi-Fi disconnected")
                }
            }
        }
    }
}