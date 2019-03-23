package fr.meteordesign.giftoforzhova.features.splashscreen

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.giftoforzhova.common.SingleLiveEvent
import fr.giftoforzhova.common.logger.Logger
import fr.meteordesign.giftoforzhova.managers.appthememanager.AppThemeManager
import fr.meteordesign.giftoforzhova.managers.cardcachemanager.CardCacheManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

private val ANIMATION_TIME_MILLI = TimeUnit.SECONDS.toMillis(2)

class SplashScreenViewModel @Inject constructor(
    private val appThemeManager: AppThemeManager,
    private val cardCacheManager: CardCacheManager
) : ViewModel() {

    private var handler = Handler()

    private val _state = MutableLiveData<SplashScreenActivity.State>()
    val state: LiveData<SplashScreenActivity.State> = _state

    private val _event = SingleLiveEvent<Event>()
    val event: LiveData<Event> = _event

    private var disposable: Disposable? = null

    init {
        _state.value = SplashScreenActivity.State.Init(appThemeManager)

        checkAppIsInitialised()
    }

    private fun checkAppIsInitialised() {
        disposable = cardCacheManager.isAppInitialized()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onCheckAppIsInitialised, ::onCheckAppIsInitialisedError)
    }

    private fun onCheckAppIsInitialised(isInitialised: Boolean) {
        if (isInitialised) {
            startApplication()
        } else {
            _event.value = Event.InitializationWarning
        }
    }

    private fun onCheckAppIsInitialisedError(throwable: Throwable) {
        Logger.e(throwable)
        // TODO manage
    }

    fun onUserPressContinue() {
        startApplication()
    }

    fun onUserPressAbort() {
        _event.value = Event.Terminate
    }

    private fun startApplication() {
        _event.value = Event.ShowAnimation(appThemeManager, ANIMATION_TIME_MILLI)
        handler.postDelayed(::onAnimationEnd, ANIMATION_TIME_MILLI)
    }

    private fun onAnimationEnd() {
        _event.value = Event.Continue
    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }

    sealed class Event {
        object InitializationWarning : Event()
        class ShowAnimation(val appThemeManager: AppThemeManager, val animationTimeMilli: Long) : Event()
        object Terminate : Event()
        object Continue : Event()
    }
}