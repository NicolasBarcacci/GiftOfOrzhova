package fr.meteordesign.repository.repositories.di

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import fr.meteordesign.repository.repositories.appsettings.APP_SETTINGS_PREFERENCES_NAME
import fr.meteordesign.repository.repositories.appsettings.AppSettingsRepository
import fr.meteordesign.repository.repositories.appsettings.AppSettingsRepositoryImpl
import fr.meteordesign.repository.repositories.cards.LocalCardRepository
import fr.meteordesign.repository.repositories.cards.RemoteCardsRepository
import fr.meteordesign.repository.repositories.cards.local.CARD_REPOSITORY_NAME
import fr.meteordesign.repository.repositories.cards.local.LocalCardRepositoryRoomImpl
import fr.meteordesign.repository.repositories.cards.remote.MTJ_JSON_BASE_URL
import fr.meteordesign.repository.repositories.cards.remote.MtgJsonCardsApi
import fr.meteordesign.repository.repositories.cards.remote.REMOTE_CARDS_REPOSITORY_PREFERENCES_NAME
import fr.meteordesign.repository.repositories.cards.remote.RemoteCardsRepositoryMtgJsonImpl
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
abstract class RepositoriesModule {

    @Binds
    abstract fun provideAppSettingsRepositoryModule(
        appSettingsRepositoryImpl: AppSettingsRepositoryImpl
    ): AppSettingsRepository

    @Binds
    abstract fun provideRemoteRepository(
        remoteCardsRepositoryMtgJsonImpl: RemoteCardsRepositoryMtgJsonImpl
    ): RemoteCardsRepository

    @Module
    companion object {

        @Provides
        @JvmStatic
        @Named(APP_SETTINGS_PREFERENCES_NAME)
        fun provideAppSettingsPreferences(context: Context): SharedPreferences =
            context.getSharedPreferences(APP_SETTINGS_PREFERENCES_NAME, Context.MODE_PRIVATE)


        @Provides
        @Named(REMOTE_CARDS_REPOSITORY_PREFERENCES_NAME)
        @JvmStatic
        fun provideRemoteCardsRepositoryPreference(context: Context): SharedPreferences =
            context.getSharedPreferences(REMOTE_CARDS_REPOSITORY_PREFERENCES_NAME, Context.MODE_PRIVATE)

        @Provides
        @JvmStatic
        fun provideMtgRetrofit(): Retrofit =
            Retrofit.Builder()
                .baseUrl(MTJ_JSON_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        @Provides
        @JvmStatic
        fun provideMtgCardsJsonApi(
            retrofit: Retrofit
        ): MtgJsonCardsApi = retrofit.create(MtgJsonCardsApi::class.java)

        @Provides
        @JvmStatic
        fun provideRoomDatabase(context: Context): LocalCardRepositoryRoomImpl =
            Room.databaseBuilder(
                context,
                LocalCardRepositoryRoomImpl::class.java,
                CARD_REPOSITORY_NAME
            ).build()

        @Provides
        @JvmStatic
        fun provideLocalCardsRepository(localCardRepositoryRoomImpl: LocalCardRepositoryRoomImpl): LocalCardRepository =
            localCardRepositoryRoomImpl.cardsDao()
    }
}