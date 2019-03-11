package fr.meteordesign.repository.repositories.cards

import androidx.room.Dao
import androidx.room.Insert
import fr.meteordesign.repository.repositories.cards.local.entity.RoomCard
import fr.meteordesign.repository.repositories.cards.local.entity.RoomSet

@Dao
interface LocalCardRepository {
    @Insert
    fun saveSet(set: RoomSet)

    @Insert
    fun saveCard(card: RoomCard)
}