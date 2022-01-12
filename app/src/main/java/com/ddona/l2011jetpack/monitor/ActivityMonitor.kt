package com.ddona.l2011jetpack.monitor

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.ddona.l2011jetpack.util.Logger

class ActivityMonitor(private val lifecycle: Lifecycle) : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun logOnCreate() {
        if (lifecycle.currentState.isAtLeast(Lifecycle.State.DESTROYED)) {

        }
        Logger.logD("doanpt", "Activity created")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun logOnStop() {
        Logger.logD("doanpt", "Activity stopped")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun logStart() {
        Logger.logD("doanpt", "Activity started")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun logPause() {
        Logger.logD("doanpt", "Activity Paused")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun logResume() {
        Logger.logD("doanpt", "Activity Resumed")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun logDestroy() {
        Logger.logD("doanpt", "Activity Destroyed")
    }
}