package fr.meteordesign.giftoforzhova.features.splashscreen.usecase

import fr.giftoforzhova.common.logger.Logger
import fr.meteordesign.repository.repositories.cards.LocalCardRepository
import fr.meteordesign.repository.repositories.cards.RemoteCardsRepository
import fr.meteordesign.repository.repositories.cards.remote.entity.RemoteSet
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

    private fun getSetsToCache(listener: Listener): Flowable<RemoteSet> =
        remoteCardsRepository.getSets()
            .map { it.filterNot { set -> isSetSaved(set) } }
            .flattenAsFlowable {
                listener.onSetToCacheCount(it.size)
                it
            }

    private fun isSetSaved(set: RemoteSet): Boolean = false

    private fun getSet(set: RemoteSet): Single<RemoteSet> =
        remoteCardsRepository.getSetCards(set.code!!)

    private fun cacheSet(remoteSet: RemoteSet, listener: Listener): Completable {
        if (remoteSet.code == null) {
            Logger.w("set has no code $remoteSet")
            listener.onSetCached()
            return Completable.complete()
        }

        val localSet = toLocalSet(remoteSet)
        val localCards = remoteSet.cards?.filterNot { it.multiverseId == null }
            ?.map { toLocalCard(localSet.code, it) }
            ?.ifEmpty {
                Logger.d("empty set $localSet")
                listener.onSetCached()
                return Completable.complete()
            }

        Logger.d("saving set $localSet")
        localCardRepository.saveSet(localSet)
        localCards?.forEach {
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