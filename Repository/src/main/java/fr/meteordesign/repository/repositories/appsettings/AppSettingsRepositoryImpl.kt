package fr.meteordesign.repository.repositories.appsettings

import android.content.SharedPreferences
import fr.meteordesign.repository.repositories.appsettings.entity.RepoAppTheme
import javax.inject.Inject
import javax.inject.Named

private const val KEY_APP_THEME = "KEY_APP_THEME"

class AppSettingsRepositoryImpl @Inject constructor(
    @Named(APP_SETTINGS_PREFERENCES_NAME) private val preferences: SharedPreferences
) : AppSettingsRepository {

    override fun getAppTheme(): RepoAppTheme? =
        RepoAppTheme.fromValue(preferences.getInt(KEY_APP_THEME, -1))
}