package com.example.interapp.logic

import androidx.recyclerview.widget.DiffUtil
import com.example.interapp.data.Item

class CardDiffCallback : DiffUtil.ItemCallback<Item>() {

    override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem == newItem

}