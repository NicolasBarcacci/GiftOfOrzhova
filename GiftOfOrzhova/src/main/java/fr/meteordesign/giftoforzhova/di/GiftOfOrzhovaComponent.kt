package fr.meteordesign.giftoforzhova.di

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import fr.meteordesign.giftoforzhova.GiftOfOrzhovaApplication

@Component(
    modules = [
        AndroidInjectionModule::class,
        GiftOfOrzhovaModule::class,
        ActivityInjector::class
    ]
)
interface GiftOfOrzhovaComponent : AndroidInjector<GiftOfOrzhovaApplication> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<GiftOfOrzhovaApplication>()
}