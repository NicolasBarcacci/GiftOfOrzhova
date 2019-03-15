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
        LocalSet.Version(
            meta?.date,
            meta?.version
        ),
        LocalSet.OtherIds(
            codeV3,
            mtgoCode,
            tcgplayerGroupId
        )
    )
}

fun toLocalCard(setCode: String, remoteCard: RemoteCard): LocalCard = with(remoteCard) {
    LocalCard(
        remoteCard.multiverseId!!,
        setCode,
        remoteCard.name,
        LocalCard.GameplayFields(
            side,
            manaCost,
            convertedManaCost,
            faceConvertedManaCost,
            colors,
            colorIdentity,
            colorIndicator,
            type,
            types,
            subtypes,
            supertypes,
            rarity,
            text,
            life,
            hand,
            loyalty,
            layout,
            power,
            toughness
        ),
        LocalCard.PrintFields(
            artist,
            names,
            originalText,
            originalType,
            flavorText,
            watermark,
            number,
            borderColor,
            frameEffect,
            frameVersion,
            hasFoil,
            hasNonFoil,
            isOversized,
            printings
        ),
        LocalCard.OtherIds(
            scryfallId,
            scryfallOracleId,
            scryfallIllustrationId,
            tcgplayerProductId,
            tcgplayerPurchaseUrl,
            uuid,
            uuidV421,
            variations
        ),
        LocalCard.Misc(
            duelDeck,
            isReserved,
            isTimeshifted,
            isStarter
        )
    )
}