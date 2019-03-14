package fr.meteordesign.repository.repositories.cards.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

internal const val CARDS_TABLE_NAME = "cards"
internal const val CARDS_COLUMN_MULTIVERSE_ID = "multiverse_id"
internal const val CARDS_COLUMN_SET_CODE = "set_code"
internal const val CARDS_COLUMN_NAME = "name"

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
    @ColumnInfo(name = CARDS_COLUMN_NAME) val name: String?
)