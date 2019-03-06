package fr.meteordesign.giftoforzhova.features.main.di

import dagger.Binds
import dagger.Module
import fr.giftoforzhova.common.navigation.Navigator
import fr.meteordesign.giftoforzhova.features.main.navigation.NavigatorImpl

@Module
abstract class MainActivityModule {

    @Binds
    abstract fun provideNavigator(navigatorImpl: NavigatorImpl): Navigator
}