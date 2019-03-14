package fr.meteordesign.giftoforzhova.features.splashscreen

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import dagger.android.support.DaggerAppCompatActivity
import fr.meteordesign.giftoforzhova.R
import kotlinx.android.synthetic.main.activity_splashscreen.*
import javax.inject.Inject

class SplashScreenActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        init()

        viewModel.state.observe(this, Observer { onStateChange(it) })
        viewModel.event.observe(this, Observer { onEvent(it) })
        viewModel.cacheCards()
    }

    private fun init() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION

        viewModel.appTheme.let { appTheme ->
            container_splashScreen_constraintLayout.setBackgroundColor(
                ContextCompat.getColor(this, appTheme.primaryColor)
            )
            appName_splashScreen_TextView.setTextColor(
                ContextCompat.getColor(
                    this,
                    if (resources.getBoolean(appTheme.darkThemeOnPrimary)) {
                        R.color.white
                    } else {
                        R.color.black
                    }
                )
            )
        }
    }

    private fun onStateChange(state: State): Unit = when (state) {
        is State.Init -> showIdleState(state)
        is State.Downloading -> showDownloadingState(state)
    }

    private fun showIdleState(state: State.Init) {
        download_splashScreen_progressBar.visibility = View.GONE
    }

    private fun showDownloadingState(state: State.Downloading) {
        download_splashScreen_progressBar.visibility = View.VISIBLE
        download_splashScreen_progressBar.isIndeterminate = state.isIndeterminate
        download_splashScreen_progressBar.max = state.count
        download_splashScreen_progressBar.progress = state.progress
    }

    private fun onEvent(event: SplashScreenViewModel.Event): Unit = when (event) {
        SplashScreenViewModel.Event.START_MAIN_ACTIVITY -> {
        } //startActivity(MainActivity.newIntent(this))
    }

    sealed class State {
        object Init : State()
        class Downloading(val isIndeterminate: Boolean, val progress: Int, val count: Int) : State()
    }
}