package fr.meteordesign.giftoforzhova

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import fr.giftoforzhova.common.logger.initLogger
import fr.meteordesign.giftoforzhova.di.DaggerGiftOfOrzhovaComponent

class GiftOfOrzhovaApplication : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
        initLogger()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerGiftOfOrzhovaComponent.builder().create(this)
}
