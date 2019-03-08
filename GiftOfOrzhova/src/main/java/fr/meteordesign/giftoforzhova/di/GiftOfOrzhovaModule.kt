package fr.meteordesign.giftoforzhova.di

import android.content.Context
import dagger.Binds
import dagger.Module
import fr.giftoforzhova.common.navigation.Navigator
import fr.meteordesign.giftoforzhova.GiftOfOrzhovaApplication
import fr.meteordesign.giftoforzhova.navigation.NavigatorImpl

@Module
abstract class GiftOfOrzhovaModule {

    @Binds
    abstract fun provideContext(application: GiftOfOrzhovaApplication): Context

    @Binds
    abstract fun provideNavigator(navigatorImpl: NavigatorImpl): Navigator
}