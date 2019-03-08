package fr.meteordesign.giftoforzhova.navigation

import android.app.Activity
import fr.giftoforzhova.common.navigation.Navigator
import javax.inject.Inject

class NavigatorImpl @Inject constructor() : Navigator {

    override fun navigateToCardList(activity: Activity): Unit =
        (activity as Navigator.Listener).navigateTo(fr.meteordesign.cardlist.R.navigation.navigation_cardlist)
}