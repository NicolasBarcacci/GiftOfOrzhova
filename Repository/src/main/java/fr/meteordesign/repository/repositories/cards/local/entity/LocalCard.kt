package fr.meteordesign.repository.repositories.cards.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

internal const val CARDS_TABLE_NAME = "cards"
internal const val CARDS_COLUMN_MULTIVERSE_ID = "multiverse_id"
internal const val CARDS_COLUMN_SET_CODE = "set_code"
internal const val CARDS_COLUMN_NAME = "name"
internal const val CARDS_COLUMN_SIDE = "side"
internal const val CARDS_COLUMN_MANA_COST = "mana_cost"
internal const val CARDS_COLUMN_CONVERTED_MANA_COST = "converted_mana_cost"
internal const val CARDS_COLUMN_FACE_CONVERTED_MANA_COST = "faceConvertedManaCost"
internal const val CARDS_COLUMN_COLORS = "colors"
internal const val CARDS_COLUMN_COLOR_IDENTITY = "color_identity"
internal const val CARDS_COLUMN_COLOR_INDICATOR = "color_indicator"
internal const val CARDS_COLUMN_TYPE = "type"
internal const val CARDS_COLUMN_TYPES = "types"
internal const val CARDS_COLUMN_SUBTYPES = "subtypes"
internal const val CARDS_COLUMN_SUPERTYPES = "supertypes"
internal const val CARDS_COLUMN_RARITY = "rarity"
internal const val CARDS_COLUMN_TEXT = "text"
internal const val CARDS_COLUMN_LIFE_MODIFIER = "life_modifier"
internal const val CARDS_COLUMN_HAND_MODIFIER = "hand_modifier"
internal const val CARDS_COLUMN_LOTALTY = "loyalty"
internal const val CARDS_COLUMN_LAYOUT = "layout"
internal const val CARDS_COLUMN_POWER = "power"
internal const val CARDS_COLUMN_TOUGHNESS = "toughness"
internal const val CARDS_COLUMN_ARTIST = "artist"
internal const val CARDS_COLUMN_RELATED_NAMES = "related_names"
internal const val CARDS_COLUMN_ORIGINAL_TEXT = "original_text"
internal const val CARDS_COLUMN_ORIGINAL_TYPE = "original_type"
internal const val CARDS_COLUMN_FLAVOUR_TEXT = "flavour_text"
internal const val CARDS_COLUMN_WATERMARK = "water_mark"
internal const val CARDS_COLUMN_COLLECTOR_NUMBER = "collector_number"
internal const val CARDS_COLUMN_BORDER_COLOR = "border_color"
internal const val CARDS_COLUMN_FRAME_EFFECT = "frame_effect"
internal const val CARDS_COLUMN_FRAME_VERSION = "frame_version"
internal const val CARDS_COLUMN_HAS_FOIL = "has_foil"
internal const val CARDS_COLUMN_HAS_NON_FOIL = "has_non_foil"
internal const val CARDS_COLUMN_IS_OVERSIZED = "is_oversized"
internal const val CARDS_COLUMN_PRINTINGS = "printings"
internal const val CARDS_COLUMN_SCRYFALL_ID = "scryfall_id"
internal const val CARDS_COLUMN_SCRYFALL_ORACLE_ID = "scryfall_oracle_id"
internal const val CARDS_COLUMN_SCRYFALL_ILLUSTRACTION_ID = "scryfall_illustration_id"
internal const val CARDS_COLUMN_TCGPLAYER_PRODUCT_ID = "tgcplayer_product_id"
internal const val CARDS_COLUMN_TCGPLAYER_PURCHASE_URL = "tgcplayer_purchase_url"
internal const val CARDS_COLUMN_UUID = "uuid"
internal const val CARDS_COLUMN_UUIDV421 = "uuidv421"
internal const val CARDS_COLUMN_UUID_VARIATIONS = "uuid_varations"
internal const val CARDS_COLUMN_DUEL_DECK = "duel_deck"
internal const val CARDS_COLUMN_IS_RESERVED = "is_reserved"
internal const val CARDS_COLUMN_IS_TIMESHIFTED = "is_timeshifted"
internal const val CARDS_COLUMN_IS_STARTER = "is_starter"

@Entity(
    tableName = CARDS_TABLE_NAME,
    foreignKeys = [ForeignKey(
        entity = LocalSet::class,
        parentColumns = [SETS_COLUMN_CODE],
        childColumns = [CARDS_COLUMN_SET_CODE]
    )]
)
data class LocalCard(
    @PrimaryKey @ColumnInfo(name = CARDS_COLUMN_MULTIVERSE_ID) val multiverseId: Int,
    @ColumnInfo(name = CARDS_COLUMN_SET_CODE) val setCode: String,
    @ColumnInfo(name = CARDS_COLUMN_NAME) val name: String?,
    @Embedded val gameplayFields: GameplayFields,
    @Embedded val printFields: PrintFields,
    @Embedded val otherIds: OtherIds,
    @Embedded val misc: Misc
) {
    data class GameplayFields(
        @ColumnInfo(name = CARDS_COLUMN_SIDE) val side: String?,
        @ColumnInfo(name = CARDS_COLUMN_MANA_COST) val manaCost: String?,
        @ColumnInfo(name = CARDS_COLUMN_CONVERTED_MANA_COST) val convertedManaCost: Float?,
        @ColumnInfo(name = CARDS_COLUMN_FACE_CONVERTED_MANA_COST) val faceConvertedManaCost: Float?,
        @ColumnInfo(name = CARDS_COLUMN_COLORS) val colors: List<String>?,
        @ColumnInfo(name = CARDS_COLUMN_COLOR_IDENTITY) val colorIdentity: List<String>?,
        @ColumnInfo(name = CARDS_COLUMN_COLOR_INDICATOR) val colorIndicator: List<String>?,
        @ColumnInfo(name = CARDS_COLUMN_TYPE) val type: String?,
        @ColumnInfo(name = CARDS_COLUMN_TYPES) val types: List<String>?,
        @ColumnInfo(name = CARDS_COLUMN_SUBTYPES) val subtypes: List<String>?,
        @ColumnInfo(name = CARDS_COLUMN_SUPERTYPES) val supertypes: List<String>?,
        @ColumnInfo(name = CARDS_COLUMN_RARITY) val rarity: String?,
        @ColumnInfo(name = CARDS_COLUMN_TEXT) val text: String?,
        @ColumnInfo(name = CARDS_COLUMN_LIFE_MODIFIER) val lifeModifier: String?,
        @ColumnInfo(name = CARDS_COLUMN_HAND_MODIFIER) val handModifier: String?,
        @ColumnInfo(name = CARDS_COLUMN_LOTALTY) val loyalty: String?,
        @ColumnInfo(name = CARDS_COLUMN_LAYOUT) val layout: String?,
        @ColumnInfo(name = CARDS_COLUMN_POWER) val power: String?,
        @ColumnInfo(name = CARDS_COLUMN_TOUGHNESS) val toughness: String?
    )

    data class PrintFields(
        @ColumnInfo(name = CARDS_COLUMN_ARTIST) val artist: String?,
        @ColumnInfo(name = CARDS_COLUMN_RELATED_NAMES) val relatedNames: List<String>?,
        @ColumnInfo(name = CARDS_COLUMN_ORIGINAL_TEXT) val originalText: String?,
        @ColumnInfo(name = CARDS_COLUMN_ORIGINAL_TYPE) val originalType: String?,
        @ColumnInfo(name = CARDS_COLUMN_FLAVOUR_TEXT) val flavorText: String?,
        @ColumnInfo(name = CARDS_COLUMN_WATERMARK) val watermark: String?,
        @ColumnInfo(name = CARDS_COLUMN_COLLECTOR_NUMBER) val collectorNumber: String?,
        @ColumnInfo(name = CARDS_COLUMN_BORDER_COLOR) val borderColor: String?,
        @ColumnInfo(name = CARDS_COLUMN_FRAME_EFFECT) val frameEffect: String?,
        @ColumnInfo(name = CARDS_COLUMN_FRAME_VERSION) val frameVersion: String?,
        @ColumnInfo(name = CARDS_COLUMN_HAS_FOIL) val hasFoil: Boolean?,
        @ColumnInfo(name = CARDS_COLUMN_HAS_NON_FOIL) val hasNonFoil: Boolean?,
        @ColumnInfo(name = CARDS_COLUMN_IS_OVERSIZED) val isOversized: Boolean?,
        @ColumnInfo(name = CARDS_COLUMN_PRINTINGS) val printings: List<String>?
    )

    data class OtherIds(
        @ColumnInfo(name = CARDS_COLUMN_SCRYFALL_ID) val scryfallId: String?,
        @ColumnInfo(name = CARDS_COLUMN_SCRYFALL_ORACLE_ID) val scryfallOracleId: String?,
        @ColumnInfo(name = CARDS_COLUMN_SCRYFALL_ILLUSTRACTION_ID) val scryfallIllustrationId: String?,
        @ColumnInfo(name = CARDS_COLUMN_TCGPLAYER_PRODUCT_ID) val tcgplayerProductId: Int?,
        @ColumnInfo(name = CARDS_COLUMN_TCGPLAYER_PURCHASE_URL) val tcgplayerPurchaseUrl: String?,
        @ColumnInfo(name = CARDS_COLUMN_UUID) val uuid: String?,
        @ColumnInfo(name = CARDS_COLUMN_UUIDV421) val uuidV421: String?,
        @ColumnInfo(name = CARDS_COLUMN_UUID_VARIATIONS) val uuidCariations: List<String>?
    )

    data class Misc(
        @ColumnInfo(name = CARDS_COLUMN_DUEL_DECK) val duelDeck: String?,
        @ColumnInfo(name = CARDS_COLUMN_IS_RESERVED) val isReserved: Boolean?,
        @ColumnInfo(name = CARDS_COLUMN_IS_TIMESHIFTED) val isTimeshifted: Boolean?,
        @ColumnInfo(name = CARDS_COLUMN_IS_STARTER) val isStarter: Boolean?
    )
}