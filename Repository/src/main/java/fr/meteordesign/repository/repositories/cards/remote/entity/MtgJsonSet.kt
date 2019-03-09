package fr.meteordesign.repository.repositories.cards.remote.entity

import com.google.gson.annotations.SerializedName

// https://mtgjson.com/structures/set/
data class MtgJsonSet(
    @SerializedName("code") val code: String?,
    @SerializedName("cards") val cards: List<MtgJsonCard>?,
    @SerializedName("name") val name: String?
)