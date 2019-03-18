package fr.meteordesign.giftoforzhova.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import fr.meteordesign.giftoforzhova.GiftOfOrzhovaApplication
import fr.meteordesign.repository.repositories.di.RepositoriesModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        GiftOfOrzhovaModule::class,
        ActivityInjector::class,
        RepositoriesModule::class
    ]
)
interface GiftOfOrzhovaComponent : AndroidInjector<GiftOfOrzhovaApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<GiftOfOrzhovaApplication>()
}