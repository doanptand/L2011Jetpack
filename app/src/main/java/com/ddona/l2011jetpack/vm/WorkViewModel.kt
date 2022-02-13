package com.ddona.l2011jetpack.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.work.*
import com.ddona.l2011jetpack.worker.SampleWorker
import java.util.concurrent.TimeUnit

class WorkViewModel(private val app: Application) : AndroidViewModel(app) {
    private val workManager = WorkManager.getInstance(app.applicationContext)

    fun downloadContent() {
        val workConstraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresCharging(true)
//            .setRequiresStorageNotLow(true)
            .build()
//        val downloadRequest = OneTimeWorkRequest.from(SampleWorker::class.java)
        val downloadRequest = OneTimeWorkRequestBuilder<SampleWorker>()
        downloadRequest.setConstraints(workConstraints)
        workManager.enqueue(downloadRequest.build())
    }


    fun downloadContentLoop() {
        val downloadRequests = PeriodicWorkRequestBuilder<SampleWorker>(20, TimeUnit.SECONDS)
        workManager.enqueueUniquePeriodicWork(
            "download",
            ExistingPeriodicWorkPolicy.REPLACE,
            downloadRequests.build()
        )
    }
}