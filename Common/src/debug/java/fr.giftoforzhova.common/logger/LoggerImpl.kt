package fr.giftoforzhova.common.logger

import timber.log.Timber

fun initLogger() {
    Timber.plant(Timber.DebugTree())
}