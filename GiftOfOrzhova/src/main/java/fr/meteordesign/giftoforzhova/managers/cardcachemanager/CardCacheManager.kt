package fr.meteordesign.giftoforzhova.managers.cardcachemanager

import fr.meteordesign.giftoforzhova.managers.cardcachemanager.usecase.CardCachingUseCase
import io.reactivex.Single
import javax.inject.Inject

class CardCacheManager @Inject constructor(
    private val cardCachingUseCase: CardCachingUseCase
) {
    fun isAppInitialized(): Single<Boolean> = cardCachingUseCase.isAppInitialized()
}

private class CardCachingListener(
) : CardCachingUseCase.Listener {

    private var count = -1
    private var progress = -1

    override fun onSetToCacheCount(count: Int) {
        this.count = count
        progress = 0
        updateProgress()
    }

    override fun onSetCached() {
        progress++
        updateProgress()
    }

    private fun updateProgress() {

    }
}