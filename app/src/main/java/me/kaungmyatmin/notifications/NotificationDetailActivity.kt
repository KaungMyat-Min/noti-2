package me.kaungmyatmin.notifications

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_notification_detail.*

class NotificationDetailActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_detail)
        val data = intent.getStringExtra("data")
        tvNotiDetail.text = data
    }
}