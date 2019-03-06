package fr.giftoforzhova.common.logger

import android.util.Log
import timber.log.Timber

fun initLogger() {
    Timber.plant(ReleaseTree())
}

private class ReleaseTree : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.ERROR || priority == Log.WARN) {
            // TODO add crash library
        }
    }
}