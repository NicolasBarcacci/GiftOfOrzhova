package fr.meteordesign.repository.repositories.cards.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import fr.meteordesign.repository.repositories.cards.RemoteCardsRepository
import fr.meteordesign.repository.repositories.cards.remote.MTJ_JSON_BASE_URL
import fr.meteordesign.repository.repositories.cards.remote.MtgJsonCardsApi
import fr.meteordesign.repository.repositories.cards.remote.REMOTE_CARDS_REPOSITORY_PREFERENCES_NAME
import fr.meteordesign.repository.repositories.cards.remote.RemoteCardsRepositoryMtgJsonImpl
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module
abstract class RemoteCardsRepositoryModule {

    @Binds
    abstract fun provideRemoteRepository(
        remoteCardsRepositoryMtgJsonImpl: RemoteCardsRepositoryMtgJsonImpl
    ): RemoteCardsRepository

    @Module
    companion object {

        @Provides
        @Named(REMOTE_CARDS_REPOSITORY_PREFERENCES_NAME)
        @JvmStatic
        fun provideRemoteCardsRepositoryPreference(context: Context): SharedPreferences =
            context.getSharedPreferences(REMOTE_CARDS_REPOSITORY_PREFERENCES_NAME, Context.MODE_PRIVATE)

        @Provides
        @JvmStatic
        fun provideMtjRetrofit(): Retrofit =
            Retrofit.Builder()
                .baseUrl(MTJ_JSON_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        @Provides
        @JvmStatic
        fun provideMtjJsonApi(
            retrofit: Retrofit
        ): MtgJsonCardsApi = retrofit.create(MtgJsonCardsApi::class.java)
    }
}