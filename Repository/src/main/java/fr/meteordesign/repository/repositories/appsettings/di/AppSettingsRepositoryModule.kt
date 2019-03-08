package fr.meteordesign.repository.repositories.appsettings.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import fr.meteordesign.repository.repositories.appsettings.APP_SETTINGS_PREFERENCES_NAME
import fr.meteordesign.repository.repositories.appsettings.AppSettingsRepository
import fr.meteordesign.repository.repositories.appsettings.AppSettingsRepositoryImpl
import javax.inject.Named

@Module
abstract class AppSettingsRepositoryModule {

    @Binds
    abstract fun provideAppSettingsRepositoryModule(
        appSettingsRepositoryImpl: AppSettingsRepositoryImpl
    ): AppSettingsRepository

    @Module
    companion object {
        @Provides
        @JvmStatic
        @Named(APP_SETTINGS_PREFERENCES_NAME)
        fun provideAppSettingsPreferences(context: Context): SharedPreferences =
            context.getSharedPreferences(APP_SETTINGS_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }
}