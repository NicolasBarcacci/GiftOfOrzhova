package fr.meteordesign.giftoforzhova.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module
abstract class GiftOfOrzhovaModule {

    @Binds
    abstract fun provideContext(application: Application): Context
}