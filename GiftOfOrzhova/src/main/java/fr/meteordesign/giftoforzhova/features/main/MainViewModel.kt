package fr.meteordesign.giftoforzhova.features.main

import androidx.lifecycle.ViewModel
import fr.meteordesign.giftoforzhova.managers.appthememanager.AppThemeManager
import javax.inject.Inject

class MainViewModel @Inject constructor(val appThemeManager: AppThemeManager) : ViewModel()