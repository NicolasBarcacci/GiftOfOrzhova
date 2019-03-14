package fr.meteordesign.repository.repositories.cards.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

internal const val SETS_TABLE_NAME = "sets"
internal const val SETS_COLUMN_CODE = "code"
internal const val SETS_COLUMN_NAME = "name"
internal const val SETS_IS_UP_TO_DATE = "is_up_to_date"

@Entity(tableName = SETS_TABLE_NAME)
data class LocalSet(
    @PrimaryKey @ColumnInfo(name = SETS_COLUMN_CODE) val code: String,
    @ColumnInfo(name = SETS_COLUMN_NAME) val name: String?,
    @ColumnInfo(name = SETS_IS_UP_TO_DATE) val isUpToDate: Boolean?
)