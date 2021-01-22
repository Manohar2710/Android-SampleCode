package com.appscrip.andvanceandroid.receiver

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.appscrip.andvanceandroid.R
import com.appscrip.andvanceandroid.utils.sendNotification

class AlarmReceiver : BroadcastReceiver() {

	override fun onReceive(context: Context, intent: Intent) {
		// This method is called when the BroadcastReceiver is receiving an Intent broadcast.
//		Toast.makeText(
//			context,
//			context.getText(R.string.eggs_ready),
//			Toast.LENGTH_SHORT
//		).show()
		val notificationManager = ContextCompat.getSystemService(
			context,
			NotificationManager::class.java
		) as NotificationManager

		notificationManager.sendNotification(
			context.getText(R.string.eggs_ready).toString(),
			context
		)
	}
}
