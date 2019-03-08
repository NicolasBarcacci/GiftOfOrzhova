package fr.meteordesign.giftoforzhova.features.main

import androidx.lifecycle.ViewModel
import fr.meteordesign.giftoforzhova.usecase.AppThemeUseCase
import fr.meteordesign.ui.UiAppTheme
import javax.inject.Inject

class MainViewModel @Inject constructor(
    appThemeUseCase: AppThemeUseCase
) : ViewModel() {
    val appTheme: UiAppTheme = appThemeUseCase.getAppTheme()
}