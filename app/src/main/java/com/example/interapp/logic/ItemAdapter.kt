package com.example.interapp.logic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.interapp.R
import com.example.interapp.dtos.*

class ItemAdapter : ListAdapter<Item, ViewHolder>(CardDiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View
        when(currentList[viewType]){
            is Info-> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.info_layout, parent, false)
            }
            is Title-> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.title_layout, parent, false)
            }
            is User -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.user_layout, parent, false)
            }
            else -> {
                view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.tariff_layout, parent, false)
            }

        }

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}

