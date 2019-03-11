package fr.meteordesign.repository.repositories.cards.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "cards",
    foreignKeys = [ForeignKey(
        entity = RoomSet::class,
        parentColumns = ["code"],
        childColumns = ["set_code"]
    )]
)
data class RoomCard(
    @PrimaryKey @ColumnInfo(name = "multiverse_id") val multiverseId: Int,
    @ColumnInfo(name = "set_code") val setCode: String,
    @ColumnInfo(name = "name") val name: String?
)