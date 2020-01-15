package com.example.databindingrecycler

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object Utils {

    @BindingAdapter("app:items")
    @JvmStatic
    fun items(recycler: RecyclerView, items: List<MessageItem>) {

        (recycler.adapter as MessagesAdapter).apply {
            addItems(items)
        }

    }

}