package com.example.interapp.logic

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.interapp.R
import com.example.interapp.dtos.*

class TariffAdapter
    : ListAdapter<Tariff, TariffAdapter.ViewHolder>(CardDiffCallback()) {

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(tariff: Tariff) {
            val title = view.findViewById<TextView>(R.id.tariff_name)
            val cost = view.findViewById<TextView>(R.id.tariff_cost)
            val speed = view.findViewById<TextView>(R.id.tariff_speed)
            title.text = tariff.name
            cost.text = tariff.cost
            speed.text = tariff.speed
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tariff_layout, parent, false)

        return ViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}

