package com.example.myapplication

import com.example.myapplication.items.CardItem
import com.example.myapplication.items.CircleItem
import com.xwray.groupie.Group

class ItemBuilder(
    private val colors: List<Int>,
    private val cardListener: CardItem.CardClickListener,
    private val circleListener: CircleItem.CircleClickListener
) {

    fun build(): List<Group> {
        return mutableListOf<Group>().apply {
            addAll(colors.map { CardItem(it, cardListener) })
            addAll(colors.map { CircleItem(it, circleListener) })
        }
    }
}