package com.example.databindingrecycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingrecycler.databinding.ItemBinding

class MessagesAdapter(private val context: Context): RecyclerView.Adapter<MessagesAdapter.MessagesViewHolder>() {

    private val items: MutableList<MessageItem> = mutableListOf()

    fun addItems(items: List<MessageItem>){
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesViewHolder {

        val binding: ItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item, parent, false)
        return MessagesViewHolder(binding)
        //return MessagesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MessagesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    //inner class MessagesViewHolder(view: View): RecyclerView.ViewHolder(view)
    inner class MessagesViewHolder(private val itemBinding: ItemBinding): RecyclerView.ViewHolder(itemBinding.root){
        fun bind(data: Any) {
            itemBinding.setVariable(BR.model, data)
            itemBinding.executePendingBindings()
        }
    }

}