package fr.meteordesign.giftoforzhova.features.splashscreen

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import dagger.android.support.DaggerAppCompatActivity
import fr.meteordesign.giftoforzhova.R
import fr.meteordesign.giftoforzhova.features.main.MainActivity
import kotlinx.android.synthetic.main.activity_splashscreen.*
import javax.inject.Inject

class SplashScreenActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        viewModel.state.observe(this, Observer { onStateChange(it) })
        viewModel.event.observe(this, Observer { onEvent(it) })
        viewModel.cacheCards()
    }

    private fun onStateChange(state: State): Unit = when (state) {
        State.Init -> showIdleState()
        is State.Downloading -> showDownloadingState(state)
    }

    private fun showIdleState() {
        download_splashScreen_progressBar.visibility = View.GONE
    }

    private fun showDownloadingState(state: State.Downloading) {
        download_splashScreen_progressBar.visibility = View.VISIBLE
        download_splashScreen_progressBar.isIndeterminate = state.isIndeterminate
        download_splashScreen_progressBar.max = state.count
        download_splashScreen_progressBar.progress = state.progress
    }

    private fun onEvent(event: SplashScreenViewModel.Event): Unit = when (event) {
        SplashScreenViewModel.Event.Ready -> startActivity(MainActivity.newIntent(this))
    }

    sealed class State {
        object Init : State()
        class Downloading(val isIndeterminate: Boolean, val progress: Int, val count: Int) : State()
    }
}