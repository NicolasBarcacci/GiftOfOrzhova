package fr.meteordesign.repository.repositories.cards.remote

import fr.meteordesign.repository.repositories.cards.RemoteCardsRepository
import fr.meteordesign.repository.repositories.cards.remote.entity.MtgJsonSet
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

internal const val MTJ_JSON_BASE_URL = "https://mtgjson.com/"

class RemoteCardsRepositoryMtgJsonImpl @Inject constructor(
    private val api: MtgJsonCardsApi
) : RemoteCardsRepository {

    override fun getSets(): Single<List<MtgJsonSet>> =
        api.getSets()
            .subscribeOn(Schedulers.io())

    override fun getSetCards(setCode: String): Single<MtgJsonSet> =
        api.getSetCards(setCode)
            .subscribeOn(Schedulers.io())
}