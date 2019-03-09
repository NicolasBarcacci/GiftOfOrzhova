package fr.meteordesign.giftoforzhova.features.splashscreen.usecase

import fr.meteordesign.repository.repositories.cards.RemoteCardsRepository
import fr.meteordesign.repository.repositories.cards.remote.entity.MtgJsonCard
import fr.meteordesign.repository.repositories.cards.remote.entity.MtgJsonSet
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class CardCachingUseCase @Inject constructor(
    private val remoteCardsRepository: RemoteCardsRepository
) {
    fun cacheCards(): Completable = getSetsToCache()
        .flatMapSingle { getSetCards(it) }
        .flatMapCompletable { cacheCards(it) }

    private fun getSetsToCache(): Flowable<MtgJsonSet> =
        remoteCardsRepository.getSets()
            .map { it.filterNot { set -> isSetSaved(set) } }
            .flattenAsFlowable { it }

    private fun isSetSaved(set: MtgJsonSet): Boolean = false

    private fun getSetCards(set: MtgJsonSet): Single<List<MtgJsonCard>> =
        remoteCardsRepository.getSetCards(set.code!!)
            .map { it.cards }

    private fun cacheCards(cards: List<MtgJsonCard>): Completable {
        // TODO save cards
        return Completable.complete()
    }
}