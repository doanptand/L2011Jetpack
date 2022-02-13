package com.ddona.l2011jetpack.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.lang.Exception

class SampleWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {
        val link = inputData.getString("link")
        return try {
            downloadFileFromNetwork(link!!)
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }

    private fun downloadFileFromNetwork(link: String) {
        Log.d("doanpt", "Downloading content from $link")
    }
}