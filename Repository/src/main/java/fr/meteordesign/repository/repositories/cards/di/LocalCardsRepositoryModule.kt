package fr.meteordesign.repository.repositories.cards.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import fr.meteordesign.repository.repositories.cards.LocalCardRepository
import fr.meteordesign.repository.repositories.cards.local.CARD_REPOSITORY_NAME
import fr.meteordesign.repository.repositories.cards.local.LocalCardRepositoryRoomImpl

@Module
class LocalCardsRepositoryModule {

    @Provides
    fun provideRoomDatabase(context: Context): LocalCardRepositoryRoomImpl =
        Room.databaseBuilder(
            context,
            LocalCardRepositoryRoomImpl::class.java,
            CARD_REPOSITORY_NAME
        ).build()

    @Provides
    fun provideLocalCardsRepository(localCardRepositoryRoomImpl: LocalCardRepositoryRoomImpl): LocalCardRepository =
        localCardRepositoryRoomImpl.cardsDao()
}