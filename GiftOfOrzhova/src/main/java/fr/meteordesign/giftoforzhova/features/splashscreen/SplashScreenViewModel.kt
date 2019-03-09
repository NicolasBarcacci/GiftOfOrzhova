package fr.meteordesign.giftoforzhova.features.splashscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.meteordesign.giftoforzhova.features.splashscreen.usecase.CardCachingUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class SplashScreenViewModel @Inject constructor(
    private val cardCachingUseCase: CardCachingUseCase
) : ViewModel(),
    CardCachingUseCase.Listener {

    private val _state = MutableLiveData<SplashScreenActivity.State>()
    val state: LiveData<SplashScreenActivity.State> = _state

    private var count = -1
    private var progress = -1

    private var disposable: Disposable? = null

    init {
        _state.value = SplashScreenActivity.State.Idle
    }

    fun cacheCards() {
        disposable?.dispose()
        disposable = cardCachingUseCase.cacheCards(this)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { _state.value = SplashScreenActivity.State.Idle }
    }

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
        _state.postValue(SplashScreenActivity.State.Downloading(progress, count))
    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }
}