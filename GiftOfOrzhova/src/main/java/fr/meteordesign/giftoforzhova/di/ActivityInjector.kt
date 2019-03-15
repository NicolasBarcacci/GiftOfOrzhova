package fr.meteordesign.giftoforzhova.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import fr.meteordesign.cardlist.features.cardlist.di.CardListFragmentInjector
import fr.meteordesign.giftoforzhova.features.apptheme.di.AppThemeModule
import fr.meteordesign.giftoforzhova.features.main.MainActivity
import fr.meteordesign.giftoforzhova.features.splashscreen.SplashScreenActivity
import fr.meteordesign.repository.repositories.appsettings.di.AppSettingsRepositoryModule
import fr.meteordesign.repository.repositories.cards.di.RemoteCardsRepositoryModule

@Module
abstract class ActivityInjector {

    @ContributesAndroidInjector(
        modules = [
            CardListFragmentInjector::class,
            AppThemeModule::class,
            AppSettingsRepositoryModule::class
        ]
    )
    abstract fun injectMainActivity(): MainActivity

    @ContributesAndroidInjector(
        modules = [
            RemoteCardsRepositoryModule::class,
            AppThemeModule::class,
            AppSettingsRepositoryModule::class
        ]
    )
    abstract fun injectSplashScreenActivity(): SplashScreenActivity
}