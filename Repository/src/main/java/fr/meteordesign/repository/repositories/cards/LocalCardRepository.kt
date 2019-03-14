package fr.meteordesign.repository.repositories.cards

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import fr.meteordesign.repository.repositories.cards.local.entity.LocalCard
import fr.meteordesign.repository.repositories.cards.local.entity.LocalSet

@Dao
interface LocalCardRepository {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveSet(set: LocalSet)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCard(card: LocalCard)
}