package fr.meteordesign.repository.repositories.cards.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import fr.meteordesign.repository.repositories.cards.LocalCardRepository
import fr.meteordesign.repository.repositories.cards.local.entity.RoomCard
import fr.meteordesign.repository.repositories.cards.local.entity.RoomSet

internal const val CARD_REPOSITORY_NAME = "cards_repository"
private const val CARD_REPOSITORY_VERSION = 1

@Database(
    version = CARD_REPOSITORY_VERSION,
    entities = [RoomSet::class, RoomCard::class]
)
@TypeConverters(ListStringConverter::class)
abstract class LocalCardRepositoryRoomImpl : RoomDatabase() {
    abstract fun cardsDao(): LocalCardRepository
}

internal class ListStringConverter {

    @TypeConverter
    fun toString(strings: List<String>?): String? = ""

    @TypeConverter
    fun toList(string: String?): List<String>? = listOf()
}