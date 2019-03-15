package fr.meteordesign.giftoforzhova.di

import android.content.Context
import dagger.Binds
import dagger.Module
import dagger.Provides
import fr.giftoforzhova.common.navigation.Navigator
import fr.meteordesign.giftoforzhova.GiftOfOrzhovaApplication
import fr.meteordesign.giftoforzhova.navigation.NavigatorImpl
import fr.meteordesign.giftoforzhova.usecase.apptheme.AppThemeUseCase
import fr.meteordesign.ui.UiAppTheme

@Module
abstract class GiftOfOrzhovaModule {

    @Binds
    abstract fun provideContext(application: GiftOfOrzhovaApplication): Context

    @Binds
    abstract fun provideNavigator(navigatorImpl: NavigatorImpl): Navigator

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideUiAppTheme(appThemeUseCase: AppThemeUseCase): UiAppTheme = appThemeUseCase.getAppTheme()
    }
}