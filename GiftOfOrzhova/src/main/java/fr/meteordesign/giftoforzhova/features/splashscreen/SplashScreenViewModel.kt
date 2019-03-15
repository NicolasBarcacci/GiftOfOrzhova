package fr.meteordesign.giftoforzhova.features.splashscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.giftoforzhova.common.SingleLiveEvent
import fr.meteordesign.giftoforzhova.features.apptheme.AppThemeManager
import fr.meteordesign.giftoforzhova.features.splashscreen.usecase.CardCachingUseCase
import fr.meteordesign.giftoforzhova.managers.WifiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class SplashScreenViewModel @Inject constructor(
    appThemeManager: AppThemeManager,
    private val wifiManager: WifiManager,
    private val cardCachingUseCase: CardCachingUseCase
) : ViewModel(),
    CardCachingUseCase.Listener {

    private val _state = MutableLiveData<SplashScreenActivity.State>()
    val state: LiveData<SplashScreenActivity.State> = _state

    private val _cacheState = MutableLiveData<SplashScreenActivity.CacheState>()
    val cacheState: LiveData<SplashScreenActivity.CacheState> = _cacheState

    private val _event = SingleLiveEvent<Event>()
    val event: LiveData<Event> = _event

    private var count = -1
    private var progress = -1

    private var disposable: Disposable? = null

    init {
        _state.value = SplashScreenActivity.State.Init(appThemeManager)
        _cacheState.value = SplashScreenActivity.CacheState.Init
    }

    fun cacheCards() {
        disposable?.dispose()
        _cacheState.value = SplashScreenActivity.CacheState.Downloading(true, 0, 0)
        disposable = cardCachingUseCase.cacheCards(this)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { _event.value = Event.Ready }
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
        _cacheState.postValue(SplashScreenActivity.CacheState.Downloading(false, progress, count))
    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }

    sealed class Event {
        object Ready : Event()
    }
}