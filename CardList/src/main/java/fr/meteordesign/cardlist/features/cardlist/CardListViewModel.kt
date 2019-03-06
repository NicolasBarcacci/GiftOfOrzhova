package fr.meteordesign.cardlist.features.cardlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.giftoforzhova.common.entities.Card

class CardListViewModel : ViewModel() {

    private val cards = listOf(
        Card("1", "https://img.scryfall.com/cards/large/en/gpt/101.jpg?1517813031"),
        Card("2", "https://img.scryfall.com/cards/large/en/gtc/153.jpg?1517813031"),
        Card("3", "https://img.scryfall.com/cards/large/front/d/6/d602e9e6-31ed-4d17-b39c-457b3b182943.jpg?1549414957")
    )

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    init {
        _state.value = State.CardList(cards)
    }
}