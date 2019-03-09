package fr.meteordesign.giftoforzhova.features.splashscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.meteordesign.giftoforzhova.R
import javax.inject.Inject

class SplashScreenActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: SplashScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        viewModel.test()
    }
}