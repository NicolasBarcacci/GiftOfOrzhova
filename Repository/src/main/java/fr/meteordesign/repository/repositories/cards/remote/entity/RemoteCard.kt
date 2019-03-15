package fr.meteordesign.repository.repositories.cards.remote.entity

import com.google.gson.annotations.SerializedName

// https://mtgjson.com/structures/card/
data class RemoteCard(
    @SerializedName("artist") val artist: String?,
    @SerializedName("borderColor") val borderColor: String?,
    @SerializedName("colorIdentity") val colorIdentity: List<String>?,
    @SerializedName("colorIndicator") val colorIndicator: List<String>?,
    @SerializedName("colors") val colors: List<String>?,
    @SerializedName("convertedManaCost") val convertedManaCost: Float?,
    @SerializedName("duelDeck") val duelDeck: String?,
    @SerializedName("faceConvertedManaCost") val faceConvertedManaCost: Float?,
    @SerializedName("flavorText") val flavorText: String?,
    @SerializedName("foreignData") val foreignData: List<ForeignData>?,
    @SerializedName("frameEffect") val frameEffect: String?,
    @SerializedName("frameVersion") val frameVersion: String?,
    @SerializedName("hand") val hand: String?,
    @SerializedName("hasFoil") val hasFoil: Boolean?,
    @SerializedName("hasNonFoil") val hasNonFoil: Boolean?,
    @SerializedName("isOnlineOnly") val isOnlineOnly: Boolean?,
    @SerializedName("isOversized") val isOversized: Boolean?,
    @SerializedName("isReserved") val isReserved: Boolean?,
    @SerializedName("isTimeshifted") val isTimeshifted: Boolean?,
    @SerializedName("layout") val layout: String?,
    @SerializedName("legalities") val legalities: Legalities?,
    @SerializedName("life") val life: String?,
    @SerializedName("loyalty") val loyalty: String?,
    @SerializedName("manaCost") val manaCost: String?,
    @SerializedName("multiverseId") val multiverseId: Int?,
    @SerializedName("name") val name: String?,
    @SerializedName("names") val names: List<String>?,
    @SerializedName("number") val number: String?,
    @SerializedName("originalText") val originalText: String?,
    @SerializedName("originalType") val originalType: String?,
    @SerializedName("power") val power: String?,
    @SerializedName("printings") val printings: List<String>?,
    @SerializedName("rarity") val rarity: String?,
    @SerializedName("rulings") val rulings: List<Rulings>?,
    @SerializedName("scryfallId") val scryfallId: String?,
    @SerializedName("scryfallOracleId") val scryfallOracleId: String?,
    @SerializedName("scryfallIllustrationId") val scryfallIllustrationId: String?,
    @SerializedName("side") val side: String?,
    @SerializedName("isStarter") val isStarter: Boolean?,
    @SerializedName("subtypes") val subtypes: List<String>?,
    @SerializedName("supertypes") val supertypes: List<String>?,
    @SerializedName("tcgplayerProductId") val tcgplayerProductId: Int?,
    @SerializedName("tcgplayerPurchaseUrl") val tcgplayerPurchaseUrl: String?,
    @SerializedName("text") val text: String?,
    @SerializedName("toughness") val toughness: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("types") val types: List<String>?,
    @SerializedName("uuid") val uuid: String?,
    @SerializedName("uuidV421") val uuidV421: String?,
    @SerializedName("variations") val variations: List<String>?,
    @SerializedName("watermark") val watermark: String?
) {
    // https://mtgjson.com/structures/foreign-data/
    data class ForeignData(
        @SerializedName("flavorText") val flavorText: String?,
        @SerializedName("language") val language: String?,
        @SerializedName("multiverseId") val multiverseId: Int?,
        @SerializedName("name") val name: String?,
        @SerializedName("text") val text: String?
    )

    // https://mtgjson.com/structures/legalities/
    data class Legalities(
        @SerializedName("commander") val commander: String?,
        @SerializedName("duel") val duel: String?,
        @SerializedName("frontier") val frontier: String?,
        @SerializedName("legacy") val legacy: String?,
        @SerializedName("modern") val modern: String?,
        @SerializedName("pauper") val pauper: String?,
        @SerializedName("penny") val penny: String?,
        @SerializedName("standard") val standard: String?,
        @SerializedName("vintage") val vintage: String?
    )

    // https://mtgjson.com/structures/rulings/
    data class Rulings(
        @SerializedName("date") val date: String?,
        @SerializedName("text") val text: String?
    )
}