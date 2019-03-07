package fr.meteordesign.ui

import androidx.annotation.BoolRes
import androidx.annotation.StyleRes

enum class UiAppTheme(
    @StyleRes val themeResId: Int,
    @BoolRes val darkOnPrimaryResId: Int,
    @BoolRes val darkOnAccentResId: Int
) {
    AZORIUS(R.style.AppThemeAzorius, R.bool.dark_on_primary_azorius, R.bool.dark_on_accent_azorius),
    BOROS(R.style.AppThemeBoros, R.bool.dark_on_primary_boros, R.bool.dark_on_accent_boros),
    DIMIR(R.style.AppThemeDimir, R.bool.dark_on_primary_dimir, R.bool.dark_on_accent_dimir),
    GOLGARI(R.style.AppThemeGolgari, R.bool.dark_on_primary_golgari, R.bool.dark_on_accent_golgari),
    GRUUL(R.style.AppThemeGruul, R.bool.dark_on_primary_gruul, R.bool.dark_on_accent_gruul),
    IZZET(R.style.AppThemeIzzet, R.bool.dark_on_primary_izzet, R.bool.dark_on_accent_izzet),
    ORZHOV(R.style.AppThemeOrzhov, R.bool.dark_on_primary_orzhov, R.bool.dark_on_accent_orzhov),
    RAKDOS(R.style.AppThemeRakdos, R.bool.dark_on_primary_rakdos, R.bool.dark_on_accent_rakdos),
    SELESNYA(R.style.AppThemeSelesnya, R.bool.dark_on_primary_selesnya, R.bool.dark_on_accent_selesnya),
    SIMIC(R.style.AppThemeSimic, R.bool.dark_on_primary_simic, R.bool.dark_on_accent_simic)
}