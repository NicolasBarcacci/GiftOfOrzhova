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
    appThemeManager: AppThemeManager,
    private val cardChacheManager: CardCacheManager
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
        disposable = cardChacheManager.isAppInitialized()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onCheckAppIsInitialised, ::onCheckAppIsInitialisedError)
    }

    private fun onCheckAppIsInitialised(isInitialised: Boolean) {
        if (isInitialised) {
            startAnimation()
        } else {
            Event.ShowAnimation(ANIMATION_TIME_MILLI)
        }
    }

    private fun onCheckAppIsInitialisedError(throwable: Throwable) {
        Logger.e(throwable)
        // TODO manage
    }

    fun onUserPressContinue() {
        startAnimation()
    }

    fun OnUserPressAbort() {
        _event.value = Event.Terminate
    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }

    private fun startAnimation() {
        handler.postDelayed(::onAnimationEnd, ANIMATION_TIME_MILLI)
    }

    private fun onAnimationEnd() {
        _event.value = Event.Continue
    }

    sealed class Event {
        object InitialiationWarning : Event()
        class ShowAnimation(animationTimeMilli: Long) : Event()
        object Terminate : Event()
        object Continue : Event()
    }
}