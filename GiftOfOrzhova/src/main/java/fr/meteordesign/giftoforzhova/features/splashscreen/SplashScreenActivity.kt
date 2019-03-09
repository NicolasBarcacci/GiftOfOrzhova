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
        viewModel.event.observe(this, Observer { startMainActivity() })
        viewModel.cacheCards()
    }

    private fun onStateChange(state: State): Unit =
        when (state) {
            State.Init -> showIdleState()
            is State.Downloading -> showDownloadingState(state)
        }

    private fun showIdleState() {
        progressBar.visibility = View.GONE
    }

    private fun showDownloadingState(state: State.Downloading) {
        progressBar.visibility = View.VISIBLE
        progressBar.max = state.count
        progressBar.progress = state.progress
    }

    private fun startMainActivity() {
        startActivity(MainActivity.newIntent(this))
    }

    sealed class State {
        object Init : State()
        class Downloading(val progress: Int, val count: Int) : State()
    }
}