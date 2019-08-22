package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*


/**
 * Список карточек с разыми цветами.
 * При нажатии цвет карточек меняется.
 */
class MainActivity : AppCompatActivity(), CardItem.CardClickListener {

    private val mainViewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }
    private lateinit var contentGroupAdapter: GroupAdapter<ViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initAdapter()
        observeColors()
        mainViewModel.shuffleColors()
    }

    private fun initAdapter() {
        contentGroupAdapter = GroupAdapter()
        recyclerView.adapter = contentGroupAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
    }

    private fun observeColors() {
        mainViewModel.liveColors.observe(this, Observer { colors ->
            contentGroupAdapter.update(colors.map { CardItem(it, this) })
        })
    }

    override fun onCardClick() {
        mainViewModel.shuffleColors()
    }
}
