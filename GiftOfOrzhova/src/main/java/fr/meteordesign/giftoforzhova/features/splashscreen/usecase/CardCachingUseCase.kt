package fr.meteordesign.giftoforzhova.features.splashscreen.usecase

import fr.meteordesign.repository.repositories.cards.RemoteCardsRepository
import javax.inject.Inject

class CardCachingUseCase @Inject constructor(
    private val remoteCardsRepository: RemoteCardsRepository
)