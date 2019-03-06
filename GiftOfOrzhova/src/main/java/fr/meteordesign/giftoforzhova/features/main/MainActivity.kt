package fr.meteordesign.giftoforzhova.features.main

import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.navigation.fragment.NavHostFragment
import dagger.android.support.DaggerAppCompatActivity
import fr.giftoforzhova.common.navigation.Navigator
import fr.meteordesign.giftoforzhova.R
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), Navigator.Listener {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator.navigateToCardList(this)
    }

    override fun navigateTo(@NavigationRes graphRes: Int) {
        val graphFragment = NavHostFragment.create(graphRes)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.navigationHost_main_FrameLayout, graphFragment)
            .setPrimaryNavigationFragment(graphFragment)
            .commit()
    }
}
