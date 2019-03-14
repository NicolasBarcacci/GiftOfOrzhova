package fr.meteordesign.repository.repositories.cards

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.meteordesign.repository.repositories.cards.local.entity.CARDS_COLUMN_SET_CODE
import fr.meteordesign.repository.repositories.cards.local.entity.CARDS_TABLE_NAME
import fr.meteordesign.repository.repositories.cards.local.entity.LocalCard
import fr.meteordesign.repository.repositories.cards.local.entity.LocalSet
import fr.meteordesign.repository.repositories.cards.local.entity.SETS_COLUMN_CODE
import fr.meteordesign.repository.repositories.cards.local.entity.SETS_IS_UP_TO_DATE
import fr.meteordesign.repository.repositories.cards.local.entity.SETS_TABLE_NAME

@Dao
interface LocalCardRepository {
    @Query("SELECT * FROM $SETS_TABLE_NAME WHERE $SETS_COLUMN_CODE = :setCode")
    fun getSet(setCode: String): LocalSet?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveSet(set: LocalSet)

    @Query("SELECT * FROM $CARDS_TABLE_NAME WHERE $CARDS_COLUMN_SET_CODE = :setCode")
    fun getCards(setCode: String): List<LocalCard>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveCard(card: LocalCard)
}