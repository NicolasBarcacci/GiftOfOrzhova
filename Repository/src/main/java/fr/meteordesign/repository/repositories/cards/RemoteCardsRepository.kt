package fr.meteordesign.repository.repositories.cards

import fr.meteordesign.repository.repositories.cards.remote.entity.MtgJsonSet
import io.reactivex.Single

interface RemoteCardsRepository {
    fun getSets(): Single<List<MtgJsonSet>>
    fun getSetCards(setCode: String): Single<MtgJsonSet>
}