package fr.meteordesign.giftoforzhova.usecase

import fr.meteordesign.ui.UiAppTheme
import javax.inject.Inject

class AppThemeUseCase @Inject constructor() {

    fun getAppTheme(): UiAppTheme = UiAppTheme.ORZHOV
}