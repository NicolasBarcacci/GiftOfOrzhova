package fr.meteordesign.repository.repositories.cards

import fr.meteordesign.repository.repositories.cards.remote.entity.RemoteSet
import fr.meteordesign.repository.repositories.cards.remote.entity.RemoteVersion
import io.reactivex.Single

interface RemoteCardsRepository {
    fun getSavedVersion(): String?
    fun getCurrentVersion(): Single<RemoteVersion>

    fun getSets(): Single<List<RemoteSet>>
    fun getSetCards(setCode: String): Single<RemoteSet>
}