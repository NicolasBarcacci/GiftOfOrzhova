package fr.giftoforzhova.common.navigation

import android.app.Activity
import androidx.annotation.NavigationRes

interface Navigator {

    fun navigateToCardList(activity: Activity)

    companion object {
        const val CARD_LIST_GRAPH_RES = "CARD_LIST_GRAPH_RES"
    }

    interface Listener {
        fun navigateTo(@NavigationRes graphRes: Int)
    }
}