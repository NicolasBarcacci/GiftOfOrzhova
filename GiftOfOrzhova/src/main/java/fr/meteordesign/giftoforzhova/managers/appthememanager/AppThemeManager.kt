package fr.meteordesign.giftoforzhova.managers.appthememanager

import android.content.Context
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StyleRes
import fr.meteordesign.giftoforzhova.R
import fr.meteordesign.ui.UiAppTheme
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppThemeManager @Inject constructor(
    context: Context,
    uiAppTheme: UiAppTheme
) {
    @StyleRes
    val themeResId = uiAppTheme.themeResId
    val isDarkTheme = context.resources.getBoolean(uiAppTheme.darkThemeOnPrimaryResId)

    @ColorRes
    val primaryColor = uiAppTheme.primaryColor
    @ColorRes
    val colorOnPrimaryColor = if (isDarkTheme) R.color.white else R.color.black

    @DrawableRes
    val guildSymbolResId = uiAppTheme.guildSymbol

    @DrawableRes
    val guildBannerResId = uiAppTheme.guildBanner
}