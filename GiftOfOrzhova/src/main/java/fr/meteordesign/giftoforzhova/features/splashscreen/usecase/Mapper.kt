package fr.meteordesign.giftoforzhova.features.splashscreen.usecase

import fr.meteordesign.repository.repositories.cards.local.entity.LocalCard
import fr.meteordesign.repository.repositories.cards.local.entity.LocalSet
import fr.meteordesign.repository.repositories.cards.remote.entity.RemoteCard
import fr.meteordesign.repository.repositories.cards.remote.entity.RemoteSet

fun toLocalSet(remoteSet: RemoteSet, isUpToDate: Boolean): LocalSet = with(remoteSet) {
    LocalSet(
        code!!,
        name,
        block,
        releaseDate,
        type,
        isFoilOnly,
        isOnlineOnly,
        baseSetSize,
        totalSetSize,
        isUpToDate,
        LocalSet.OtherIds(
            codeV3,
            mtgoCode,
            tcgplayerGroupId
        ),
        LocalSet.Version(
            meta?.date,
            meta?.version
        )
    )
}

fun toLocalCard(setCode: String, remoteCard: RemoteCard): LocalCard = LocalCard(
    multiverseId = remoteCard.multiverseId!!,
    setCode = setCode,
    name = remoteCard.name
)