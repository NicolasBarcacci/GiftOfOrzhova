package fr.meteordesign.repository.repositories.cards.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

internal const val SETS_TABLE_NAME = "sets"
internal const val SETS_COLUMN_CODE = "code"
internal const val SETS_COLUMN_NAME = "name"
internal const val SETS_COLUMN_BLOCK = "block"
internal const val SETS_COLUMN_RELEASE_DATE = "release_date"
internal const val SETS_COLUMN_TYPE = "type"
internal const val SETS_COLUMN_IS_FOIL_ONLY = "is_foil_only"
internal const val SETS_COLUMN_IS_ONLINE_ONLY = "is_online_only"
internal const val SETS_COLUMN_BASE_SET_SIZE = "base_set_size"
internal const val SETS_COLUMN_TOTAL_SET_SIZE = "total_set_size"
internal const val SETS_COLUMN_IS_UP_TO_DATE = "is_up_to_date"
internal const val SETS_COLUMN_CODE_V3 = "code_v3"
internal const val SETS_COLUMN_MTGO_CODE = "mtgo_code"
internal const val SETS_COLUMN_TGCPLAYER_GROUP_ID = "tcgplayer_group_id"
internal const val SETS_COLUMN_DATE = "date"
internal const val SETS_COLUMN_VERSION = "version"

@Entity(tableName = SETS_TABLE_NAME)
data class LocalSet(
    @PrimaryKey @ColumnInfo(name = SETS_COLUMN_CODE) val code: String,
    @ColumnInfo(name = SETS_COLUMN_NAME) val name: String?,
    @ColumnInfo(name = SETS_COLUMN_BLOCK) val block: String?,
    @ColumnInfo(name = SETS_COLUMN_RELEASE_DATE) val releaseDate: String?,
    @ColumnInfo(name = SETS_COLUMN_TYPE) val type: String?,
    @ColumnInfo(name = SETS_COLUMN_IS_FOIL_ONLY) val isFoilOnly: Boolean?,
    @ColumnInfo(name = SETS_COLUMN_IS_ONLINE_ONLY) val isOnlineOnly: Boolean?,
    @ColumnInfo(name = SETS_COLUMN_BASE_SET_SIZE) val baseSetSize: Int?,
    @ColumnInfo(name = SETS_COLUMN_TOTAL_SET_SIZE) val totalSetSize: Int?,
    @ColumnInfo(name = SETS_COLUMN_IS_UP_TO_DATE) val isUpToDate: Boolean?,
    @Embedded val remoteVersion: Version?,
    @Embedded val otherIds: OtherIds?
) {
    data class OtherIds(
        @ColumnInfo(name = SETS_COLUMN_CODE_V3) val codeV3: String?,
        @ColumnInfo(name = SETS_COLUMN_MTGO_CODE) val mtgoCode: String?,
        @ColumnInfo(name = SETS_COLUMN_TGCPLAYER_GROUP_ID) val tcgplayerGroupId: Int?
    )

    data class Version(
        @SerializedName(SETS_COLUMN_DATE) val date: String?,
        @SerializedName(SETS_COLUMN_VERSION) val version: String?
    )
}