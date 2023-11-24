package com.fullm3tal.interviewpreparation

import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

public val CHANNEL_ID = "301"
public class NotificationService : Service() {

    val id = 1

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            Actions.START.toString() -> start()
            Actions.STOP.toString() -> stopSelf()
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun start() {
        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground).setContentTitle("Run is Active")
            .setContentText("Elapsed time : 00:50").build()
        startForeground(id, notification)
    }

    enum class Actions {
        START, STOP
    }

}