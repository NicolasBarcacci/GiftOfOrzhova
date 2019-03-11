package fr.meteordesign.repository.repositories.cards.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RoomSet(
    @PrimaryKey @ColumnInfo(name = "code") val code: String,
    @ColumnInfo(name = "name") val name: String?
)