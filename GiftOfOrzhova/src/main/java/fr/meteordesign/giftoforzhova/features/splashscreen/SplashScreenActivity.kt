package fr.meteordesign.giftoforzhova.features.splashscreen

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import dagger.android.support.DaggerAppCompatActivity
import fr.meteordesign.giftoforzhova.R
import fr.meteordesign.giftoforzhova.managers.AppThemeManager
import fr.meteordesign.giftoforzhova.features.main.MainActivity
import kotlinx.android.synthetic.main.activity_splashscreen.*
import javax.inject.Inject

class SplashScreenActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION

        viewModel.state.observe(this, Observer { onStateChange(it) })
        viewModel.cacheState.observe(this, Observer { onCacheStateChange(it) })
        viewModel.event.observe(this, Observer { onEvent(it) })
        viewModel.cacheCards()
    }

    private fun onStateChange(state: State): Unit = when (state) {
        is State.Init -> {
            state.appThemeManager.let { appTheme ->
                container_splashScreen_constraintLayout.setBackgroundColor(
                    ContextCompat.getColor(this, appTheme.primaryColor)
                )
                appName_splashScreen_TextView.setTextColor(
                    ContextCompat.getColor(this, appTheme.colorOnPrimaryColor)
                )
            }
        }
    }

    private fun onCacheStateChange(cacheState: CacheState): Unit = when (cacheState) {
        CacheState.Init -> showIdleState()
        is CacheState.Downloading -> showDownloadingState(cacheState)
    }

    private fun showIdleState() {
        download_splashScreen_progressBar.visibility = View.GONE
    }

    private fun showDownloadingState(cacheState: CacheState.Downloading) {
        download_splashScreen_progressBar.visibility = View.VISIBLE
        download_splashScreen_progressBar.isIndeterminate = cacheState.isIndeterminate
        download_splashScreen_progressBar.max = cacheState.count
        download_splashScreen_progressBar.progress = cacheState.progress
    }

    private fun onEvent(event: SplashScreenViewModel.Event): Unit = when (event) {
        SplashScreenViewModel.Event.Ready -> startActivity(MainActivity.newIntent(this))
    }

    sealed class State {
        class Init(val appThemeManager: AppThemeManager) : State()
    }

    sealed class CacheState {
        object Init : CacheState()
        class Downloading(val isIndeterminate: Boolean, val progress: Int, val count: Int) : CacheState()
    }
}