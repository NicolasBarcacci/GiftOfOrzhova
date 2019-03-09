package fr.meteordesign.giftoforzhova.features.splashscreen

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import fr.meteordesign.giftoforzhova.R
import javax.inject.Inject

class SplashScreenActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
    }
}