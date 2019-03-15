package fr.meteordesign.repository.repositories.cards.remote.entity

import com.google.gson.annotations.SerializedName

// https://mtgjson.com/structures/set/
data class RemoteSet(
    @SerializedName("baseSetSize") val baseSetSize: Int?,
    @SerializedName("block") val block: String?,
    @SerializedName("boosterV3") val boosterV3: List<Any>?,
    @SerializedName("cards") val cards: List<RemoteCard>?,
    @SerializedName("code") val code: String?,
    @SerializedName("codeV3") val codeV3: String?,
    @SerializedName("isFoilOnly") val isFoilOnly: Boolean?,
    @SerializedName("isOnlineOnly") val isOnlineOnly: Boolean?,
    @SerializedName("meta") val meta: Version?,
    @SerializedName("mtgoCode") val mtgoCode: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("releaseDate") val releaseDate: String?,
    @SerializedName("tcgplayerGroupId") val tcgplayerGroupId: Int?,
    @SerializedName("totalSetSize") val totalSetSize: Int?,
    @SerializedName("type") val type: String?
) {
    // https://mtgjson.com/files/version/
    data class Version(
        @SerializedName("date") val date: String?,
        @SerializedName("version") val version: String?
    )
}