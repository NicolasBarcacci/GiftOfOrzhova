package fr.meteordesign.giftoforzhova.features.splashscreen.usecase

import fr.giftoforzhova.common.logger.Logger
import fr.meteordesign.repository.repositories.cards.LocalCardRepository
import fr.meteordesign.repository.repositories.cards.RemoteCardsRepository
import fr.meteordesign.repository.repositories.cards.remote.entity.RemoteSet
import io.reactivex.Completable
import javax.inject.Inject

class CardCachingUseCase @Inject constructor(
    private val remoteCardsRepository: RemoteCardsRepository,
    private val localCardRepository: LocalCardRepository
) {
    fun cacheCards(listener: Listener): Completable = remoteCardsRepository.getSets()
        .map { removedSavedSets(it) }
        .flattenAsFlowable { sets -> sets.also { listener.onSetToCacheCount(sets.size) } }
        .flatMapSingle { set -> remoteCardsRepository.getSetCards(set.code!!) }
        .flatMapCompletable {
            cacheSetAndCards(it, listener)
        }

    private fun removedSavedSets(sets: List<RemoteSet>): List<RemoteSet> =
        sets.filterNot { set ->
            val hasNullCode = (set.code == null)
            if (hasNullCode) {
                Logger.w("Downloaded a set with no code $set")
            }
            hasNullCode
        }.filterNot { remoteSet -> localCardRepository.getSet(remoteSet.code!!)?.isUpToDate ?: false }

    private fun cacheSetAndCards(remoteSet: RemoteSet, listener: Listener): Completable {
        val setCode = remoteSet.code!!

        localCardRepository.saveSet(toLocalSet(remoteSet, false))
        remoteSet.cards?.filterNot { it.multiverseId == null }
            ?.map { toLocalCard(setCode, it) }
            ?.forEach {
                localCardRepository.saveCard(it)
            }
        localCardRepository.saveSet(toLocalSet(remoteSet, true))

        listener.onSetCached()
        return Completable.complete()
    }

    interface Listener {
        fun onSetToCacheCount(count: Int)
        fun onSetCached()
    }
}