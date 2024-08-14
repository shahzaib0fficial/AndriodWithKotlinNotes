package com.example.app13_waterme.data

import android.content.Context
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf

class WorkManagerRepository(context: Context): Repository {
    private val workManager = WorkManager.getInstance(context)

    private val constraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.NOT_REQUIRED) // No network constraints
        .setRequiresBatteryNotLow(false) // Battery level is not a constraint
        .setRequiresCharging(false) // Charging status is not a constraint
        .build()

    override fun setReminder(name: String) {
        val workRequest = OneTimeWorkRequestBuilder<Worker>()
            .setInputData(workDataOf("NAME" to name))
            .setConstraints(constraints)
            .build()

        workManager.enqueue(workRequest)
    }
}