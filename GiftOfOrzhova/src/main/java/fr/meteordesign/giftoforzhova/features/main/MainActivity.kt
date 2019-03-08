package fr.meteordesign.giftoforzhova.features.main

import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.navigation.fragment.NavHostFragment
import dagger.android.support.DaggerAppCompatActivity
import fr.giftoforzhova.common.navigation.Navigator
import fr.meteordesign.giftoforzhova.R
import fr.meteordesign.ui.UiAppTheme
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), Navigator.Listener {

    @Inject
    lateinit var navigator: Navigator

    private val viewModel = MainViewModel()
    private lateinit var appTheme: UiAppTheme

    override fun onCreate(savedInstanceState: Bundle?) {
        appTheme = viewModel.appTheme
        setTheme(appTheme.themeResId)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()

        navigator.navigateToCardList(this)
    }

    private fun initToolbar() {
        val isDark = resources.getBoolean(appTheme.darkOnPrimaryResId)
        toolbar_main_stub.apply {
            layoutResource = if (isDark) R.layout.appbarlayout_main_dark else R.layout.appbarlayout_main_light
            inflate()
        }
        setSupportActionBar(toolbar_main)
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
