package com.example.myapplication.items

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class CardViewModel: ViewModel() {

    private lateinit var data: Data

    var text: MutableLiveData<String> = MutableLiveData()
    var color: MutableLiveData<Int> = MutableLiveData()

    fun buttonClicked() {
        text.postValue(Calendar.getInstance().time.toString())
    }

    fun cardClicked() {
        data.listener.onCardClick()
    }

    fun init(color: Int, listener: CardItem.Listener) {
        if (::data.isInitialized) {
            return
        }

        data = Data(color, listener)

        this.text.postValue(null)
        this.color.postValue(data.color)
    }

    private class Data(val color: Int, val listener: CardItem.Listener)
}