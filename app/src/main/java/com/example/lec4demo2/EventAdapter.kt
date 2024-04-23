package com.example.lec4demo2

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventAdapter(
    val eventsmain : List<Event>,
    val context : Context
) : RecyclerView.Adapter<EventAdapter.MyEateryViewHolder>() {

    class MyEateryViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val nameText : TextView = view.findViewById(R.id.eventNameText)
        val timeText : TextView = view.findViewById(R.id.eventTimeText)
        val locationText : TextView = view.findViewById(R.id.eventLocationText)
        val image : ImageView = view.findViewById(R.id.organizationLogoImg)
        val background : ImageView = view.findViewById(R.id.eventBackgColorImage)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyEateryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.eatery_cell, parent, false)
        return MyEateryViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyEateryViewHolder, position: Int) {
        val events : Event = eventsmain[position]
       //sets each new event in the event list that displays on screen with propeties given
        holder.nameText.text = events.eventName
        holder.image.setImageResource(events.imageiD)
        holder.background.setImageResource(R.drawable.organizationcolorsquare)
        holder.timeText.text = events.eventTime
        holder.locationText.text = events.eventLocation
        var colored = events.color
        holder.background.setColorFilter(Color.parseColor(colored))


    }


    override fun getItemCount(): Int {
        return eventsmain.size
    }
}