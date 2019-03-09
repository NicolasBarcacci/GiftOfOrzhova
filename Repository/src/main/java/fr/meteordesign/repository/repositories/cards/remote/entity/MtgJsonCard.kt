package fr.meteordesign.repository.repositories.cards.remote.entity

import com.google.gson.annotations.SerializedName

// https://mtgjson.com/structures/card/
data class MtgJsonCard(
    @SerializedName("multiverseId") val multiverseId: Int?,
    @SerializedName("name") val name: String?
)