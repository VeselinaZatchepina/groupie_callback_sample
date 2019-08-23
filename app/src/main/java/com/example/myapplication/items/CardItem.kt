package com.example.myapplication.items

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.xwray.groupie.kotlinandroidextensions.Item
import com.xwray.groupie.kotlinandroidextensions.ViewHolder
import kotlinx.android.synthetic.main.item_card.view.*

class CardItem(private val color: Int, private val listener: Listener) : Item() {

    private lateinit var viewModel: CardViewModel

    private lateinit var textObserver: Observer<String>
    private lateinit var colorObserver: Observer<Int>

    override fun bind(viewHolder: ViewHolder, position: Int) {
        with(viewHolder.itemView) {
            val fragmentActivity = context as FragmentActivity

            viewModel = ViewModelProviders.of(fragmentActivity).get(color.toString(), CardViewModel::class.java)

            textObserver = Observer {
                txt.text = it
            }

            colorObserver = Observer {
                card.setCardBackgroundColor(it)
            }

            viewModel.text.observe(fragmentActivity, textObserver)
            viewModel.color.observe(fragmentActivity, colorObserver)

            btn.setOnClickListener{
                viewModel.buttonClicked()
            }

            card.setOnClickListener {
                viewModel.cardClicked()
            }

            viewModel.init(color, listener)
        }
    }

    override fun unbind(viewHolder: ViewHolder) {
        viewModel.text.removeObserver(textObserver)
        viewModel.color.removeObserver(colorObserver)

        super.unbind(viewHolder)
    }

    override fun getLayout() = R.layout.item_card

    interface Listener {

        fun onCardClick()
    }
}

