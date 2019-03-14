package fr.meteordesign.ui

import androidx.annotation.BoolRes
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StyleRes

enum class UiAppTheme(
    @StyleRes val themeResId: Int,
    @ColorRes val primaryColor: Int,
    @BoolRes val darkThemeOnPrimaryResId: Int,
    @BoolRes val darkThemeOnAccentResId: Int,
    @DrawableRes val guildBanner: Int
) {
    AZORIUS(
        R.style.AppThemeAzorius,
        R.color.primary_azorius,
        R.bool.dark_theme_on_primary_azorius,
        R.bool.dark_theme_on_accent_azorius,
        R.drawable.banner_azorius
    ),
    BOROS(
        R.style.AppThemeBoros,
        R.color.primary_boros,
        R.bool.dark_theme_on_primary_boros,
        R.bool.dark_theme_on_accent_boros,
        R.drawable.banner_boros
    ),
    DIMIR(
        R.style.AppThemeDimir,
        R.color.primary_dimir,
        R.bool.dark_theme_on_primary_dimir,
        R.bool.dark_theme_on_accent_dimir,
        R.drawable.banner_dimir
    ),
    GOLGARI
        (
        R.style.AppThemeGolgari,
        R.color.primary_golgari,
        R.bool.dark_theme_on_primary_golgari,
        R.bool.dark_theme_on_accent_golgari,
        R.drawable.banner_golgari
    ),
    GRUUL(
        R.style.AppThemeGruul,
        R.color.primary_gruul,
        R.bool.dark_theme_on_primary_gruul,
        R.bool.dark_theme_on_accent_gruul,
        R.drawable.banner_gruul
    ),
    IZZET(
        R.style.AppThemeIzzet,
        R.color.primary_azorius,
        R.bool.dark_theme_on_primary_izzet,
        R.bool.dark_theme_on_accent_izzet,
        R.drawable.banner_izzet
    ),
    ORZHOV(
        R.style.AppThemeOrzhov,
        R.color.primary_orzhov,
        R.bool.dark_theme_on_primary_orzhov,
        R.bool.dark_theme_on_accent_orzhov,
        R.drawable.banner_orzhov
    ),
    RAKDOS(
        R.style.AppThemeRakdos,
        R.color.primary_rakdos,
        R.bool.dark_theme_on_primary_rakdos,
        R.bool.dark_theme_on_accent_rakdos,
        R.drawable.banner_rakdos
    ),
    SELESNYA(
        R.style.AppThemeSelesnya,
        R.color.primary_selesnya,
        R.bool.dark_theme_on_primary_selesnya,
        R.bool.dark_theme_on_accent_selesnya,
        R.drawable.banner_selesnya
    ),
    SIMIC(
        R.style.AppThemeSimic,
        R.color.primary_simic,
        R.bool.dark_theme_on_primary_simic,
        R.bool.dark_theme_on_accent_simic,
        R.drawable.banner_simic
    )
}