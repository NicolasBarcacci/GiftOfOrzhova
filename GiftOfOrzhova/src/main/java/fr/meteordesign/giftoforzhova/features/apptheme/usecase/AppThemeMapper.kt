package fr.meteordesign.giftoforzhova.features.apptheme.usecase

import fr.meteordesign.repository.repositories.appsettings.entity.RepoAppTheme
import fr.meteordesign.ui.UiAppTheme

fun toUiAppTheme(repoAppTheme: RepoAppTheme): UiAppTheme =
    when (repoAppTheme) {
        RepoAppTheme.AZORIUS -> UiAppTheme.AZORIUS
        RepoAppTheme.BOROS -> UiAppTheme.BOROS
        RepoAppTheme.DIMIR -> UiAppTheme.DIMIR
        RepoAppTheme.GOLGARI -> UiAppTheme.GOLGARI
        RepoAppTheme.GRUUL -> UiAppTheme.GRUUL
        RepoAppTheme.IZZET -> UiAppTheme.IZZET
        RepoAppTheme.ORZHOV -> UiAppTheme.ORZHOV
        RepoAppTheme.RAKDOS -> UiAppTheme.RAKDOS
        RepoAppTheme.SELESNYA -> UiAppTheme.SELESNYA
        RepoAppTheme.SIMIC -> UiAppTheme.SIMIC
    }