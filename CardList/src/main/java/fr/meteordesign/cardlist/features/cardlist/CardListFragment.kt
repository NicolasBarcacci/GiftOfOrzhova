package fr.meteordesign.cardlist.features.cardlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import dagger.android.support.DaggerFragment
import fr.giftoforzhova.common.entities.Card
import fr.giftoforzhova.common.navigation.Navigator
import fr.meteordesign.cardlist.R
import kotlinx.android.synthetic.main.fragment_cardlist.*
import javax.inject.Inject

class CardListFragment : DaggerFragment() {

    @Inject
    lateinit var navigator: Navigator

    private val cardListRecyclerViewAdapter = CardListRecyclerViewAdapter()

    private val viewModel = CardListViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_cardlist, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cardList_RecyclerView.adapter = cardListRecyclerViewAdapter

        viewModel.state.observe(this, Observer { onStateChange(it) })
    }

    private fun onStateChange(state: State): Unit = when (state) {
        State.NoCard -> goToNoCardState()
        is State.CardList -> gotToCardListState(state)
    }

    private fun goToNoCardState() {
        noCardMessage_cardList_TextView.visibility = View.VISIBLE
        cardList_RecyclerView.visibility = View.GONE
    }

    private fun gotToCardListState(state: State.CardList) {
        noCardMessage_cardList_TextView.visibility = View.GONE
        cardList_RecyclerView.visibility = View.VISIBLE
        cardListRecyclerViewAdapter.submitList(state.cards)
    }
}

sealed class State {
    object NoCard : State()
    class CardList(val cards: List<Card>) : State()
}