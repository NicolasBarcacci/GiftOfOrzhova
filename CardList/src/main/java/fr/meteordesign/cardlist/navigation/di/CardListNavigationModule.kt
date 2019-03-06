package fr.meteordesign.cardlist.navigation.di

import dagger.Module
import dagger.Provides
import fr.giftoforzhova.common.navigation.Navigator
import fr.meteordesign.cardlist.R
import javax.inject.Named

@Module
class CardListNavigationModule {

    @Provides
    @Named(Navigator.CARD_LIST_GRAPH_RES)
    fun provideCardListGraphRes(): Int = R.navigation.navigation_cardlist
}