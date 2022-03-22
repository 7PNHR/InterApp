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

class ItemAdapter : ListAdapter<Item, ItemAdapter.ViewHolder>(CardDiffCallback()) {

    class ViewHolder(var view: View) : RecyclerView.ViewHolder(view) {

        fun bind(item: Item) {
            when(item){
                is User ->{
                    val icon = view.findViewById<ImageView>(R.id.user_icon)
                    val text = view.findViewById<TextView>(R.id.user_text)
                    text.text = item.text
                    icon.setImageDrawable(item.drawable)
                }
                is Title -> {
                    val text = view.findViewById<TextView>(R.id.title_title)
                    text.text = item.title
                    text.textSize = item.textSize.toFloat()
                }
                is Info -> {
                    val ls = view.findViewById<TextView>(R.id.info_ls)
                    val balance = view.findViewById<TextView>(R.id.info_balance)
                    val dept = view.findViewById<TextView>(R.id.info_dept)
                    ls.text = item.ls
                    balance.text = item.balance
                    dept.text = String.format("К оплате за %s %s",item.month,item.dept)
                }
                is Tariff -> {
                    val title = view.findViewById<TextView>(R.id.tariff_name)
                    val cost = view.findViewById<TextView>(R.id.tariff_cost)
                    val speed = view.findViewById<TextView>(R.id.tariff_speed)
                    title.text = item.name
                    cost.text = item.cost
                    speed.text = item.speed
                }
            }
        }
    }

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

