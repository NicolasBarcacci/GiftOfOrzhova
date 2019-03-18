package fr.meteordesign.giftoforzhova.features.splashscreen

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import dagger.android.support.DaggerAppCompatActivity
import fr.meteordesign.giftoforzhova.R
import fr.meteordesign.giftoforzhova.features.main.MainActivity
import fr.meteordesign.giftoforzhova.managers.appthememanager.AppThemeManager
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
        viewModel.event.observe(this, Observer { onEvent(it) })
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

    private fun onEvent(event: SplashScreenViewModel.Event): Unit = when (event) {
        SplashScreenViewModel.Event.InitialiationWarning -> {
            // TODO show init popup
            viewModel.onUserPressContinue()
        }
        is SplashScreenViewModel.Event.ShowAnimation -> {
            // TODO Display animation
        }
        SplashScreenViewModel.Event.Terminate -> {
            // TODO show error message
            finish()
        }
        SplashScreenViewModel.Event.Continue -> {
            startActivity(MainActivity.newIntent(this))
            finish()
        }
    }

    sealed class State {
        class Init(val appThemeManager: AppThemeManager) : State()
    }

    sealed class CacheState {
        object Init : CacheState()
    }
}