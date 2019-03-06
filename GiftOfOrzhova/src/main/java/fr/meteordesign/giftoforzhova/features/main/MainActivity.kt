package fr.meteordesign.giftoforzhova.features.main

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import fr.meteordesign.giftoforzhova.R

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
