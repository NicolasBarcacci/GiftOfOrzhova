package fr.meteordesign.giftoforzhova.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import fr.meteordesign.cardlist.features.cardlist.di.CardListFragmentInjector
import fr.meteordesign.giftoforzhova.features.main.MainActivity
import fr.meteordesign.giftoforzhova.features.splashscreen.SplashScreenActivity
import fr.meteordesign.repository.repositories.cards.di.RemoteCardsRepositoryModule

@Module
abstract class ActivityInjector {

    @ContributesAndroidInjector(
        modules = [
            CardListFragmentInjector::class
        ]
    )
    abstract fun injectMainActivity(): MainActivity

    @ContributesAndroidInjector(
        modules = [
            RemoteCardsRepositoryModule::class
        ]
    )
    abstract fun injectSplashScreenActivity(): SplashScreenActivity
}