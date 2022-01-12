package com.ddona.l2011jetpack.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ddona.l2011jetpack.monitor.ActivityMonitor

open class BaseActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMonitor = ActivityMonitor(lifecycle)
        lifecycle.addObserver(activityMonitor)
    }
}