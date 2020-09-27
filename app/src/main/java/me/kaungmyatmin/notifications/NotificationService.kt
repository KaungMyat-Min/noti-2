package me.kaungmyatmin.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class NotificationService : FirebaseMessagingService() {
    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        createNotificationChannel()
        handleMessage(message)

    }

    private fun handleMessage(remoteMessage: RemoteMessage) {

        val notiBuilder = NotificationCompat.Builder(this, Constants.NOTI_CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle(remoteMessage.notification?.title?.toString())
            .setContentText("Hi, this is normal notification")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        val notification = notiBuilder.build()

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(1, notification)
        Log.d("ssss",remoteMessage.notification?.title?:"noTitle")
        Log.d("ssss",remoteMessage.data["asdf"]?:"noData")
        //1
        val handler = Handler(Looper.getMainLooper())

        //2
        handler.post(Runnable {
            Toast.makeText(
                baseContext, "receive",
                Toast.LENGTH_LONG
            ).show()
        }
        )
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                Constants.NOTI_CHANNEL_ID,
                "Normal notifications",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.description = "This channel will show default notifications"
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }

    }
}