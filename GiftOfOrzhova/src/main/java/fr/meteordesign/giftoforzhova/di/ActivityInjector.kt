package fr.meteordesign.giftoforzhova.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import fr.meteordesign.cardlist.navigation.di.CardListNavigationModule
import fr.meteordesign.giftoforzhova.features.main.MainActivity
import fr.meteordesign.giftoforzhova.features.main.di.MainActivityModule
import fr.meteordesign.cardlist.features.cardlist.di.CardListFragmentInjector

@Module
abstract class ActivityInjector {

    @ContributesAndroidInjector(
        modules = [
            CardListFragmentInjector::class,
            MainActivityModule::class,
            CardListNavigationModule::class]
    )
    abstract fun injectMainActivity(): MainActivity
}