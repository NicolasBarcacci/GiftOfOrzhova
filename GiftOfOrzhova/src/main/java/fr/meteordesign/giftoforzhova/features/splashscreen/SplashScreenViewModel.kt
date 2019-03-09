package fr.meteordesign.giftoforzhova.features.splashscreen

import fr.meteordesign.giftoforzhova.features.splashscreen.usecase.CardCachingUseCase
import javax.inject.Inject

class SplashScreenViewModel @Inject constructor(
    private val cardCachingUseCase: CardCachingUseCase
)