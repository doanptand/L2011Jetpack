package com.ddona.l2011jetpack.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.work.*
import com.ddona.l2011jetpack.worker.*
import java.util.concurrent.TimeUnit

class WorkViewModel(private val app: Application) : AndroidViewModel(app) {
    private val workManager = WorkManager.getInstance(app.applicationContext)
    val sampleWorkInfo = workManager.getWorkInfosByTagLiveData("download_link")

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

    fun downloadLink(link: String) {
        val downloadRequest = OneTimeWorkRequestBuilder<SampleWorker>()

        val constraint = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresCharging(true)
        downloadRequest.setConstraints(constraint.build())

        val workData = workDataOf(
            "sample" to "Doanpt1",
            "number" to 1000
        )
        val data = Data.Builder()
        data.putString("link", link)
        data.putAll(workData)
        downloadRequest.setInputData(data.build())
        downloadRequest.addTag("download_link")
        val request = downloadRequest.build()
        workManager.enqueueUniqueWork(
            "download_with_link",
            ExistingWorkPolicy.REPLACE,
            request
        )
    }

    fun runChain() {
        val workA1 = OneTimeWorkRequest.from(WorkerA1::class.java)
        val workA2 = OneTimeWorkRequest.from(WorkerA2::class.java)
        val workA3 = OneTimeWorkRequest.from(WorkerA3::class.java)
        val workB = OneTimeWorkRequest.from(WorkerB::class.java)
        val workC = OneTimeWorkRequest.from(WorkerC::class.java)
        workManager
            .beginWith(listOf(workA1, workA2, workA3))
            .then(workB)
            .then(workC).enqueue()
    }


}