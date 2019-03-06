package fr.giftoforzhova.common.logger

import timber.log.Timber

object Logger {

    inline fun v(t: Throwable): Unit = Timber.v(t)

    inline fun v(message: String, vararg args: Any): Unit = Timber.v(message, args)

    inline fun v(t: Throwable, message: String, vararg args: Any): Unit = Timber.v(t, message, args)

    inline fun d(t: Throwable): Unit = Timber.d(t)

    inline fun d(message: String, vararg args: Any): Unit = Timber.d(message, args)

    inline fun d(t: Throwable, message: String, vararg args: Any): Unit = Timber.d(t, message, args)

    inline fun i(t: Throwable): Unit = Timber.i(t)

    inline fun i(message: String, vararg args: Any): Unit = Timber.i(message, args)

    inline fun i(t: Throwable, message: String, vararg args: Any): Unit = Timber.i(t, message, args)

    inline fun w(t: Throwable): Unit = Timber.w(t)

    inline fun w(message: String, vararg args: Any): Unit = Timber.w(message, args)

    inline fun w(t: Throwable, message: String, vararg args: Any): Unit = Timber.w(t, message, args)

    inline fun e(t: Throwable): Unit = Timber.e(t)

    inline fun e(message: String, vararg args: Any): Unit = Timber.e(message, args)

    inline fun e(t: Throwable, message: String, vararg args: Any): Unit = Timber.e(t, message, args)
}