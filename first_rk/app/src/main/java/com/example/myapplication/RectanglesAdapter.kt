package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RectanglesAdapter : RecyclerView.Adapter<RectanglesAdapter.ViewHolder>() {

    private val rectanglesList = mutableListOf<Int>()

    init {
        for (i in 0 until 20) {
            rectanglesList.add(i)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rectangleNumber: TextView = view.findViewById(R.id.rectangle_number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rectangle, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.rectangleNumber.text = rectanglesList[position].toString()

        val backgroundColor = if (position % 2 == 0) {
            android.R.color.holo_red_light
        } else {
            android.R.color.holo_blue_light
        }
        holder.rectangleNumber.setBackgroundResource(backgroundColor)
    }

    override fun getItemCount() = rectanglesList.size

    fun addRectangle() {
        rectanglesList.add(rectanglesList.size)
        notifyItemInserted(rectanglesList.size - 1)
    }
}
