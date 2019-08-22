package com.example.myapplication

import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_card.view.*

class CardItem(private val color: Int, private val listener: CardClickListener) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        with(viewHolder.itemView) {
            card.setCardBackgroundColor(color)
            card.setOnClickListener {
                listener.shuffleColors()
            }
        }
    }

    override fun getLayout() = R.layout.item_card

    interface CardClickListener {

        fun shuffleColors()
    }
}