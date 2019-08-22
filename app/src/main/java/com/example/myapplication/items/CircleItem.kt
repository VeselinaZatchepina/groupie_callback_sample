package com.example.myapplication.items

import com.example.myapplication.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_card.view.*

class CircleItem(private val color: Int, private val listener: CircleClickListener) : Item() {

    override fun bind(viewHolder: ViewHolder, position: Int) {
        with(viewHolder.itemView) {
            card.setCardBackgroundColor(color)
            card.setOnClickListener {
                listener.onCircleClick()
            }
        }
    }

    override fun getLayout() = R.layout.item_circle

    interface CircleClickListener {

        fun onCircleClick()
    }
}