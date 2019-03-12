package fr.meteordesign.giftoforzhova.features.splashscreen.usecase

import fr.meteordesign.repository.repositories.cards.local.entity.RoomCard
import fr.meteordesign.repository.repositories.cards.local.entity.RoomSet
import fr.meteordesign.repository.repositories.cards.remote.entity.MtgJsonCard
import fr.meteordesign.repository.repositories.cards.remote.entity.MtgJsonSet

fun toRoomSet(mtgJsonSet: MtgJsonSet): RoomSet = RoomSet(
    code = mtgJsonSet.code!!,
    name = mtgJsonSet.name
)

fun toRoomCard(setCode: String, mtgJsonCard: MtgJsonCard): RoomCard = RoomCard(
    multiverseId = mtgJsonCard.multiverseId!!,
    setCode = setCode,
    name = mtgJsonCard.name
)