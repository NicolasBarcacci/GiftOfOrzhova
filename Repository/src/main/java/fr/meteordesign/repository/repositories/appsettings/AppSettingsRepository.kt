package fr.meteordesign.repository.repositories.appsettings

import fr.meteordesign.repository.repositories.appsettings.entity.RepoAppTheme

internal const val APP_SETTINGS_PREFERENCES_NAME = "app_settings"

interface AppSettingsRepository {
    fun getAppTheme(): RepoAppTheme?
}