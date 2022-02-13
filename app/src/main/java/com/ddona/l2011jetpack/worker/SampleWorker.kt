package com.ddona.l2011jetpack.worker

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import java.lang.Exception
import java.lang.IllegalArgumentException

class SampleWorker(ctx: Context, params: WorkerParameters) : Worker(ctx, params) {
    override fun doWork(): Result {
        val link = inputData.getString("link")
        return try {
            downloadFileFromNetwork(link!!)
            val outData = workDataOf("is_success" to true, "image" to "path")
            Result.success(outData)
        } catch (e: Exception) {
            val outData = workDataOf("is_success" to false)
            Result.failure(outData)
        }
    }

    private fun downloadFileFromNetwork(link: String) {
        Log.d("doanpt", "Downloading content from $link")
    }
}