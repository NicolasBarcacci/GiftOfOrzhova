package fr.meteordesign.giftoforzhova.features.splashscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.giftoforzhova.common.SingleLiveEvent
import fr.giftoforzhova.common.logger.Logger
import fr.meteordesign.giftoforzhova.features.splashscreen.usecase.CardCachingUseCase
import fr.meteordesign.giftoforzhova.managers.AppThemeManager
import fr.meteordesign.giftoforzhova.managers.WifiManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class SplashScreenViewModel @Inject constructor(
    appThemeManager: AppThemeManager,
    private val wifiManager: WifiManager,
    private val cardCachingUseCase: CardCachingUseCase
) : ViewModel() {

    private val _state = MutableLiveData<SplashScreenActivity.State>()
    val state: LiveData<SplashScreenActivity.State> = _state

    private val _cacheState = MutableLiveData<SplashScreenActivity.CacheState>()
    val cacheState: LiveData<SplashScreenActivity.CacheState> = _cacheState

    private val _event = SingleLiveEvent<Event>()
    val event: LiveData<Event> = _event

    private var vmState = VmState.CHECKING_INITIALISATION

    private var disposable: Disposable? = null

    init {
        _state.value = SplashScreenActivity.State.Init(appThemeManager)
        _cacheState.value = SplashScreenActivity.CacheState.Init
    }

    fun start() {
        Logger.d("MYTAG start")
        checkAppIsInitialised()
    }

    private fun checkAppIsInitialised() {
        disposable = cardCachingUseCase.isAppInitialized()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onCheckAppIsInitialised, ::onCheckAppIsInitialisedError)
    }

    private fun onCheckAppIsInitialised(isInitialised: Boolean): Unit = when (vmState) {
        VmState.CHECKING_INITIALISATION -> {
            Logger.d("MYTAG onCheckAppIsInitialised vmState=$vmState isInitialised=$isInitialised")
            if (isInitialised) {
                vmState = VmState.APP_INITIALIZED
                checkNewVersion()

            } else {
                vmState = VmState.APP_NOT_INITIALIZED
                _event.value = Event.OnInit
            }
        }
        VmState.APP_NOT_INITIALIZED -> forbidden()
        VmState.APP_INITIALIZED -> forbidden()
        VmState.NEW_VERSION -> forbidden()
        VmState.DOWNLOADING -> forbidden()
        VmState.ABORTED -> forbidden()
        VmState.READY -> forbidden()
    }

    private fun onCheckAppIsInitialisedError(throwable: Throwable) {
        Logger.e(throwable)
        // TODO manage
    }

    private fun checkNewVersion() {
        Logger.d("MYTAG checkNewVersion")
        disposable = cardCachingUseCase.isThereANewVersion()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onCheckNewVersion, ::onCheckNewVersionError)
    }

    private fun onCheckNewVersion(newVersion: Boolean): Unit = when (vmState) {
        VmState.CHECKING_INITIALISATION -> forbidden()
        VmState.APP_NOT_INITIALIZED -> forbidden()
        VmState.APP_INITIALIZED -> {
            Logger.d("MYTAG onCheckNewVersion vmState=$vmState newVersion=$newVersion")
            if (newVersion) {
                vmState = VmState.NEW_VERSION
                _event.value = Event.NewUpdates

            } else {
                vmState = VmState.READY
                _event.value = Event.Continue
            }
        }
        VmState.NEW_VERSION -> forbidden()
        VmState.DOWNLOADING -> forbidden()
        VmState.ABORTED -> forbidden()
        VmState.READY -> forbidden()
    }

    private fun onCheckNewVersionError(throwable: Throwable) {
        Logger.e(throwable)
        // TODO manage
    }

    fun startDownload(): Unit = when (vmState) {
        VmState.CHECKING_INITIALISATION -> forbidden()
        VmState.APP_NOT_INITIALIZED -> {
            Logger.d("MYTAG startDownload vmState=$vmState")
            vmState = VmState.DOWNLOADING
            cacheCards()
        }
        VmState.APP_INITIALIZED -> forbidden()
        VmState.NEW_VERSION -> {
            Logger.d("MYTAG startDownload vmState=$vmState")
            vmState = VmState.DOWNLOADING
            cacheCards()
        }
        VmState.DOWNLOADING -> forbidden()
        VmState.ABORTED -> forbidden()
        VmState.READY -> forbidden()
    }

    fun abortDownload(): Unit = when (vmState) {
        VmState.CHECKING_INITIALISATION -> forbidden()
        VmState.APP_NOT_INITIALIZED -> {
            Logger.d("MYTAG abortDownload vmState=$vmState")
            vmState = VmState.ABORTED
            _event.value = Event.Terminate
        }
        VmState.APP_INITIALIZED -> forbidden()
        VmState.NEW_VERSION -> {
            Logger.d("MYTAG abortDownload vmState=$vmState")
            vmState = VmState.READY
            _event.value = Event.Continue
        }
        VmState.DOWNLOADING -> forbidden()
        VmState.ABORTED -> forbidden()
        VmState.READY -> forbidden()
    }

    private fun cacheCards() {
        Logger.d("MYTAG cacheCards")
//        _cacheState.value = SplashScreenActivity.CacheState.Downloading(true, 0, 0)
//        disposable = cardCachingUseCase.cacheCards(CardCachingListener(_cacheState))
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(::onCardCache, ::onCardCacheError)
    }

    private fun onCardCache(): Unit = when (vmState) {
        VmState.CHECKING_INITIALISATION -> forbidden()
        VmState.APP_NOT_INITIALIZED -> forbidden()
        VmState.APP_INITIALIZED -> forbidden()
        VmState.NEW_VERSION -> forbidden()
        VmState.DOWNLOADING -> {
            Logger.d("MYTAG onCardCache vmState=$vmState")
            vmState = VmState.READY
            _event.value = Event.Continue
        }
        VmState.ABORTED -> forbidden()
        VmState.READY -> forbidden()
    }

    private fun onCardCacheError(throwable: Throwable) {
        Logger.e(throwable)
        // TODO manage
    }

    private inline fun forbidden() {
        Logger.w("shouldn't happen vmState=$vmState")
    }

    override fun onCleared() {
        disposable?.dispose()
        super.onCleared()
    }

    sealed class Event {
        object OnInit : Event()
        object NewUpdates : Event()
        object Terminate : Event()
        object Continue : Event()
    }

    private enum class VmState {
        CHECKING_INITIALISATION,
        APP_NOT_INITIALIZED,
        APP_INITIALIZED,
        NEW_VERSION,
        DOWNLOADING,
        ABORTED,
        READY
    }

    private class CardCachingListener(
        private val _cacheState: MutableLiveData<SplashScreenActivity.CacheState>
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
            _cacheState.postValue(SplashScreenActivity.CacheState.Downloading(false, progress, count))
        }
    }
}