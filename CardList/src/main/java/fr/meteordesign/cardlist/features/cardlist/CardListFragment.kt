package fr.meteordesign.cardlist.features.cardlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import fr.giftoforzhova.common.navigation.Navigator
import fr.meteordesign.cardlist.R
import javax.inject.Inject

class CardListFragment : DaggerFragment() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_card_list, container, false)
}