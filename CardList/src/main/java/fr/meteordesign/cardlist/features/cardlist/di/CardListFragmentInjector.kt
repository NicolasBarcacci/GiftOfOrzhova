package fr.meteordesign.cardlist.features.cardlist.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import fr.meteordesign.cardlist.features.cardlist.CardListFragment

@Module
abstract class CardListFragmentInjector {

    @ContributesAndroidInjector
    abstract fun injectCardListFragment(): CardListFragment
}