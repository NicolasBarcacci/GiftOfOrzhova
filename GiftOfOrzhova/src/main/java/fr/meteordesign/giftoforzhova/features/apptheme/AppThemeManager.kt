package fr.meteordesign.giftoforzhova.features.apptheme

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.StyleRes
import fr.meteordesign.ui.UiAppTheme
import javax.inject.Inject

class AppThemeManager @Inject constructor(
    context: Context,
    uiAppTheme: UiAppTheme
) {
    @StyleRes
    val themeResId = uiAppTheme.themeResId
    val isDarkTheme = context.resources.getBoolean(uiAppTheme.darkThemeOnPrimaryResId)

    @DrawableRes
    val guildBannerResId = uiAppTheme.guildBanner
}