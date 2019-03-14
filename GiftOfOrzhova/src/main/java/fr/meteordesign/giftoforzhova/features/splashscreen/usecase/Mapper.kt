package fr.meteordesign.giftoforzhova.features.splashscreen.usecase

import fr.meteordesign.repository.repositories.cards.local.entity.LocalCard
import fr.meteordesign.repository.repositories.cards.local.entity.LocalSet
import fr.meteordesign.repository.repositories.cards.remote.entity.MtgJsonCard
import fr.meteordesign.repository.repositories.cards.remote.entity.RemoteSet

fun toLocalSet(remoteSet: RemoteSet): LocalSet = LocalSet(
    code = remoteSet.code!!,
    name = remoteSet.name
)

fun toLocalCard(setCode: String, RemoteCard: MtgJsonCard): LocalCard = LocalCard(
    multiverseId = RemoteCard.multiverseId!!,
    setCode = setCode,
    name = RemoteCard.name
)