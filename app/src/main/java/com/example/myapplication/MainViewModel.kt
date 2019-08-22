package com.example.myapplication

import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val colors = listOf(
        Color.parseColor("#9AE29F"),
        Color.parseColor("#EB7D71"),
        Color.parseColor("#8FC1E7")
    )
    val liveColors = MutableLiveData<List<Int>>()

    fun shuffleColors() {
        liveColors.value = colors.shuffled()
    }
}