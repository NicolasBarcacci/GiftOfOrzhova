package fr.meteordesign.cardlist.features.cardlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import fr.giftoforzhova.common.entities.Card
import fr.giftoforzhova.common.extentions.load
import fr.meteordesign.cardlist.R

class CardListRecyclerViewAdapter : ListAdapter<Card, CardViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder =
        CardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false))

    override fun onBindViewHolder(holder: CardViewHolder, position: Int): Unit =
        holder.bind(getItem(position))

    private companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Card>() {
            override fun areItemsTheSame(oldItem: Card, newItem: Card): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(oldItem: Card, newItem: Card): Boolean = oldItem == newItem
        }
    }
}

class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(card: Card) {
        itemView.findViewById<ImageView>(R.id.image_card_imageView).load(card.imageUrl)
    }
}