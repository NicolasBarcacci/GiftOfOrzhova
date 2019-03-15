package fr.meteordesign.giftoforzhova.features.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import androidx.annotation.NavigationRes
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.navigation.NavigationView
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import fr.giftoforzhova.common.extentions.load
import fr.giftoforzhova.common.navigation.Navigator
import fr.meteordesign.giftoforzhova.R
import fr.meteordesign.giftoforzhova.features.apptheme.AppThemeManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(),
    HasSupportFragmentInjector,
    NavigationView.OnNavigationItemSelectedListener,
    Navigator.Listener {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModel: MainViewModel

    private lateinit var appThemeManager: AppThemeManager

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        appThemeManager = initTheme()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initToolbar()
        initDrawerMenu()

        navigator.navigateToCardList(this)
    }

    private fun initTheme(): AppThemeManager = viewModel.appThemeManager.also {
        setTheme(it.themeResId)
    }

    private fun initToolbar() {
        toolbar_main_stub.apply {
            layoutResource = if (appThemeManager.isDarkTheme) {
                R.layout.appbarlayout_main_dark
            } else {
                R.layout.appbarlayout_main_light
            }
            inflate()
        }
        setSupportActionBar(toolbar_main)
    }

    private fun initDrawerMenu() {
        val toggle = ActionBarDrawerToggle(
            this,
            drawer_main_drawerLayout,
            toolbar_main,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_main_drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        (nav_main_navigationView.getHeaderView(0) as ImageView).load(appThemeManager.guildBannerResId)

        nav_main_navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_main_drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawer_main_drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean = false

    override fun navigateTo(@NavigationRes graphRes: Int) {
        val graphFragment = NavHostFragment.create(graphRes)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.navigationHost_main_FrameLayout, graphFragment)
            .setPrimaryNavigationFragment(graphFragment)
            .commit()
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    companion object {
        fun newIntent(context: Context): Intent =
            Intent(context, MainActivity::class.java)
    }
}
