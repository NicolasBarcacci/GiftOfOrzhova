package fr.meteordesign.giftoforzhova.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import fr.meteordesign.cardlist.navigation.di.CardListNavigationModule
import fr.meteordesign.giftoforzhova.features.main.di.MainActivityModule
import fr.meteordesign.giftoforzhova.features.main.MainActivity

@Module
abstract class ActivityInjector {

    @ContributesAndroidInjector(modules = [MainActivityModule::class, CardListNavigationModule::class])
    abstract fun injectMainActivity(): MainActivity
}