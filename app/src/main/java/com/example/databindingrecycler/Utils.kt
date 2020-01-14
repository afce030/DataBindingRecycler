package com.example.databindingrecycler

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

object Utils {

    @BindingAdapter("app:items")
    @JvmStatic
    fun items(recycler: RecyclerView, items: List<MessageItem>) {
        val adapter = (recycler.adapter) as MessagesAdapter
        adapter.addItems(items)
    }

}