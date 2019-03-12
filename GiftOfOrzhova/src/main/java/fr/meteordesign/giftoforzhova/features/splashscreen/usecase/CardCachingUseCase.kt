package fr.meteordesign.giftoforzhova.features.splashscreen.usecase

import fr.giftoforzhova.common.logger.Logger
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

    private fun cacheSet(mtgJsonSet: MtgJsonSet, listener: Listener): Completable {
        if (mtgJsonSet.code == null) {
            Logger.w("set has no code $mtgJsonSet")
            listener.onSetCached()
            return Completable.complete()
        }

        val roomSet = toRoomSet(mtgJsonSet)
        val roomCards = mtgJsonSet.cards?.filterNot { it.multiverseId == null }
            ?.map { toRoomCard(roomSet.code, it) }
            ?.ifEmpty {
                Logger.d("empty set $roomSet")
                listener.onSetCached()
                return Completable.complete()
            }

        Logger.d("saving set $roomSet")
        localCardRepository.saveSet(roomSet)
        roomCards?.forEach {
            Logger.d("saving card $it")
            localCardRepository.saveCard(it)
        }

        listener.onSetCached()
        return Completable.complete()
    }

    interface Listener {
        fun onSetToCacheCount(count: Int)
        fun onSetCached()
    }
}