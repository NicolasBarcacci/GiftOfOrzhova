package fr.meteordesign.giftoforzhova.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import fr.meteordesign.giftoforzhova.feature.main.di.MainActivityModule
import fr.meteordesign.giftoforzhova.features.main.MainActivity

@Module
abstract class ActivityInjector {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun injectMainActivity(): MainActivity
}