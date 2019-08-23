package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.items.CardItem
import com.example.myapplication.items.CircleItem
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Список карточек с разыми цветами.
 * При нажатии цвет карточек меняется.
 */
class MainActivity : AppCompatActivity() {

    private val mainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private val contentGroupAdapter: GroupAdapter<ViewHolder> = GroupAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAdapter()
        observeColors()
        mainViewModel.shuffleColors()
    }

    private fun initAdapter() {
        recyclerView.adapter = contentGroupAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    private fun observeColors() {
        mainViewModel.liveColors.observe(this, Observer { colors ->
            contentGroupAdapter.update(ItemBuilder(colors, cardClickListener, circleClickListener).build())
        })
    }

    private val cardClickListener = object : CardItem.Listener {

        override fun onCardClick() {
            mainViewModel.shuffleColors()
        }
    }

    private val circleClickListener = object : CircleItem.Listener {

        override fun onCircleClick() {
            mainViewModel.shuffleColors()
        }
    }
}
