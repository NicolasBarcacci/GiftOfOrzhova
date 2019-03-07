package fr.meteordesign.repository.repositories.appsettings

import fr.meteordesign.repository.repositories.appsettings.entity.RepoAppTheme

interface AppSettingsRepository {
    fun getAppTheme(): RepoAppTheme?
}