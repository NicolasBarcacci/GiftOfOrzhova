package fr.meteordesign.giftoforzhova.usecase

import fr.meteordesign.repository.repositories.appsettings.AppSettingsRepository
import fr.meteordesign.ui.UiAppTheme
import javax.inject.Inject

class AppThemeUseCase @Inject constructor(
    private val appSettingsRepository: AppSettingsRepository
) {

    fun getAppTheme(): UiAppTheme = UiAppTheme.ORZHOV
}