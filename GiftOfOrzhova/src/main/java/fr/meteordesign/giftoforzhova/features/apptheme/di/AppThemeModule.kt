package fr.meteordesign.giftoforzhova.features.apptheme.di

import dagger.Module
import dagger.Provides
import fr.meteordesign.giftoforzhova.features.apptheme.usecase.AppThemeUseCase
import fr.meteordesign.ui.UiAppTheme

@Module
class AppThemeModule {

    @Provides
    fun provideUiAppTheme(appThemeUseCase: AppThemeUseCase): UiAppTheme = appThemeUseCase.getAppTheme()
}