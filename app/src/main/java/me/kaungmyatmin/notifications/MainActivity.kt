package me.kaungmyatmin.notifications

import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var notificationManager: NotificationManagerCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notificationManager = NotificationManagerCompat.from(this)

        btnNormalNoti.setOnClickListener {
            val intent = Intent(this, NotificationDetailActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                .putExtra("data", "Normal Notification")
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)


            val notiBuilder = NotificationCompat.Builder(this, Constants.NOTI_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Normal Notification")
                .setContentText("Hi, this is normal notification")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)

            val notification = notiBuilder.build()


            notificationManager.notify(1, notification)

        }

        btnBigTextNoti.setOnClickListener {
            val notiBuilder = NotificationCompat.Builder(this, Constants.NOTI_CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentTitle("Normal Notification")
                .setContentText("Hi, this is normal notification")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .setStyle(
                    NotificationCompat.BigTextStyle()
                        .bigText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam luctus in lorem sed vulputate. Sed vitae commodo nunc, et condimentum sapien. Cras pulvinar dictum ullamcorper. Curabitur non sapien sem. Duis convallis mauris vel lorem bibendum feugiat. Phasellus dolor tellus, convallis eu scelerisque vitae, tincidunt vitae felis. In finibus ante non faucibus rhoncus. Donec cursus, elit ac commodo ornare, felis magna luctus nisi, in lobortis augue risus sit amet arcu. Praesent id ante urna. Nunc dolor purus, fringilla sed molestie in, dignissim eget ipsum.")
                        .setBigContentTitle("Big text Notification")
                        .setSummaryText("Summary text")
                )
            val notification = notiBuilder.build()


            notificationManager.notify(2, notification)
        }

    }
}