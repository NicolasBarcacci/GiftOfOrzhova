package fr.meteordesign.giftoforzhova.features.splashscreen.usecase

import fr.meteordesign.repository.repositories.cards.LocalCardRepository
import fr.meteordesign.repository.repositories.cards.RemoteCardsRepository
import fr.meteordesign.repository.repositories.cards.remote.entity.MtgJsonSet
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import javax.inject.Inject

class CardCachingUseCase @Inject constructor(
    private val remoteCardsRepository: RemoteCardsRepository,
    private val localCardRepository: LocalCardRepository
) {
    fun cacheCards(listener: Listener): Completable = getSetsToCache(listener)
        .flatMapSingle { getSet(it) }
        .flatMapCompletable { cacheSet(it, listener) }

    private fun getSetsToCache(listener: Listener): Flowable<MtgJsonSet> =
        remoteCardsRepository.getSets()
            .map { it.filterNot { set -> isSetSaved(set) } }
            .flattenAsFlowable {
                listener.onSetToCacheCount(it.size)
                it
            }

    private fun isSetSaved(set: MtgJsonSet): Boolean = false

    private fun getSet(set: MtgJsonSet): Single<MtgJsonSet> =
        remoteCardsRepository.getSetCards(set.code!!)

    private fun cacheSet(set: MtgJsonSet, listener: Listener): Completable {
        listener.onSetCached()
        return Completable.complete()
    }

    interface Listener {
        fun onSetToCacheCount(count: Int)
        fun onSetCached()
    }
}