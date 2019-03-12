package fr.meteordesign.repository.repositories.cards

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import fr.meteordesign.repository.repositories.cards.local.entity.RoomCard
import fr.meteordesign.repository.repositories.cards.local.entity.RoomSet

@Dao
interface LocalCardRepository {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveSet(set: RoomSet)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCard(card: RoomCard)
}