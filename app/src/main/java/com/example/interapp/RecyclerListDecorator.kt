package com.example.interapp

import android.graphics.Canvas
import android.graphics.Rect
import android.graphics.drawable.Drawable
import android.view.View
import androidx.core.view.children
import androidx.recyclerview.widget.RecyclerView
import com.example.interapp.dtos.*

class RecyclerListDecorator(private val items : List<Item>, private val divider: Drawable) : RecyclerView.ItemDecoration() {

    private val dividerWidth = divider.intrinsicWidth
    private val dividerHeight = divider.intrinsicHeight

    override fun getItemOffsets(rect: Rect, v: View, parent: RecyclerView, s: RecyclerView.State) {
        parent.adapter?.let { adapter ->
            val childAdapterPosition = parent.getChildAdapterPosition(v)
                .let { if (it == RecyclerView.NO_POSITION) return else it }
            rect.bottom = // Add space/"padding" on right side
                if (childAdapterPosition == adapter.itemCount - 1 ) 0    // No "padding"
                else dividerHeight                                    // Drawable width "padding"
        }
    }

    override fun onDraw(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(canvas, parent, state)
        parent.adapter?.let { adapter ->
            parent.children // Displayed children on screen
                .forEach { view ->
                    val childAdapterPosition = parent.getChildAdapterPosition(view)
                        .let { if (it == RecyclerView.NO_POSITION) return else it }
                    if (childAdapterPosition != adapter.itemCount - 1 &&
                        childAdapterPosition != 0 &&
                        isItemsSame( childAdapterPosition, childAdapterPosition+1)) {
                        val left = 120
                        val top = view.bottom
                        val right = left + dividerWidth
                        val bottom = view.bottom + dividerHeight
                        divider.bounds = Rect(left, top, right, bottom)
                        divider.draw(canvas)
                    }
                }
        }
    }

    fun isItemsSame( firstElementPosition: Int, SecondElementPosition: Int ): Boolean{
        when(items[firstElementPosition]){
            is Info -> {
                if(items[SecondElementPosition] is Info)
                    return true
            }
            is Title -> {
                if(items[SecondElementPosition] is Title)
                    return true
            }
            is UserInfo -> {
                if(items[SecondElementPosition] is UserInfo)
                    return true
            }
            is Tariff ->{
                if(items[SecondElementPosition] is Tariff)
                    return true
            }
        }
        return false
    }
}