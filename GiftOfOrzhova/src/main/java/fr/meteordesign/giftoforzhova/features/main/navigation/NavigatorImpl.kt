package fr.meteordesign.giftoforzhova.features.main.navigation

import android.app.Activity
import fr.giftoforzhova.common.navigation.Navigator
import javax.inject.Inject
import javax.inject.Named

class NavigatorImpl @Inject constructor(
    @Named(Navigator.CARD_LIST_GRAPH_RES) val cardListGraphRes: Int
) : Navigator {

    override fun navigateToCardList(activity: Activity): Unit =
        (activity as Navigator.Listener).navigateTo(cardListGraphRes)
}