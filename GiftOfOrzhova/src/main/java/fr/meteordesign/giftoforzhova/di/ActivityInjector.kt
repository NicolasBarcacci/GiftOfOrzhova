package fr.meteordesign.giftoforzhova.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import fr.meteordesign.cardlist.features.cardlist.di.CardListFragmentInjector
import fr.meteordesign.giftoforzhova.features.main.MainActivity
import fr.meteordesign.repository.repositories.appsettings.di.AppSettingsRepositoryModule

@Module
abstract class ActivityInjector {

    @ContributesAndroidInjector(modules = [CardListFragmentInjector::class, AppSettingsRepositoryModule::class])
    abstract fun injectMainActivity(): MainActivity
}