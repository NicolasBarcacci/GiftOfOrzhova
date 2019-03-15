package fr.meteordesign.giftoforzhova.usecase.apptheme

import fr.meteordesign.repository.repositories.appsettings.AppSettingsRepository
import fr.meteordesign.ui.UiAppTheme
import javax.inject.Inject

private val DEFAULT_THEME = UiAppTheme.ORZHOV

class AppThemeUseCase @Inject constructor(
    private val appSettingsRepository: AppSettingsRepository
) {
    fun getAppTheme(): UiAppTheme = appSettingsRepository.getAppTheme()?.let {
        toUiAppTheme(
            it
        )
    } ?: DEFAULT_THEME
}