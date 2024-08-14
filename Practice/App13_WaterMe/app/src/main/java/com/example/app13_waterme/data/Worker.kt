package com.example.app13_waterme.data

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.app13_waterme.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class Worker(ctx: Context, prams: WorkerParameters): CoroutineWorker(ctx,prams) {
    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO){
            return@withContext try {
                delay(5000L)
                val name = inputData.getString("NAME") ?: "No Name"
                showNotification(name,applicationContext)
                Result.success()
            }catch (throwable:Throwable){
                Result.failure()
            }
        }
    }

    fun showNotification(name:String,context: Context){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Water Me WorkManager Notifications"
            val description = "Shows notifications whenever Reminder starts"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel("WATER_ME_NOTIFICATION", name, importance)
            channel.description = description

            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?
            notificationManager?.createNotificationChannel(channel)
        }

        val builder = NotificationCompat.Builder(context, "WATER_ME_NOTIFICATION")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Reminder")
            .setContentText("Water: $name")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setVibrate(LongArray(0))


        NotificationManagerCompat.from(context).notify(1, builder.build())
    }
}