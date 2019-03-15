package fr.meteordesign.giftoforzhova.features.apptheme

import android.content.Context
import fr.meteordesign.ui.UiAppTheme
import javax.inject.Inject

class AppThemeManager @Inject constructor(
    private val context: Context,
    private val uiAppTheme: UiAppTheme
)