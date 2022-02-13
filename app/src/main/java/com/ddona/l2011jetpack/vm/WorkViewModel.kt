package com.ddona.l2011jetpack.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.ddona.l2011jetpack.worker.SampleWorker

class WorkViewModel(private val app: Application) : AndroidViewModel(app) {
    private val workManager = WorkManager.getInstance(app.applicationContext)

    fun downloadContent() {
        val downloadRequest = OneTimeWorkRequest.from(SampleWorker::class.java)
//        val downloadRequest2 = OneTimeWorkRequestBuilder<SampleWorker>()
        workManager.enqueue(downloadRequest)
    }
}