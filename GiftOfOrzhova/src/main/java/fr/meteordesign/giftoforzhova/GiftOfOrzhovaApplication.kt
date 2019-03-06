package fr.meteordesign.giftoforzhova

import android.app.Application
import fr.giftoforzhova.common.logger.initLogger

class GiftOfOrzhovaApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initLogger()
    }
}