package fr.meteordesign.repository.repositories.cards

import fr.meteordesign.repository.repositories.cards.remote.entity.RemoteSet
import io.reactivex.Single

interface RemoteCardsRepository {
    fun getSets(): Single<List<RemoteSet>>
    fun getSetCards(setCode: String): Single<RemoteSet>
}