package com.example.lec4demo2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Date
import java.util.Locale


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
            var contributerlogo = R.drawable.o16logo
            var contributercolor = "#34BEE3"
            var addingEvent  : Boolean

           //background code
            val background : ImageView = findViewById(R.id.background)
            background.setImageResource(R.drawable.cibkgrd)
            background.scaleX = 1.3F

            //event frame code, set color to new color
            var frame : ImageView = findViewById(R.id.imageView2)
            frame.setImageResource(R.drawable.eventsframe)
            frame.setColorFilter(Color.parseColor("#D9D9D9"))

            //TEXT FOR DATE, Format
            val datetext : TextView = findViewById(R.id.dateTextView)
            val sdf = SimpleDateFormat("MMMM dd,  yyyy", Locale.getDefault())
            val currentDateandTime: String = sdf.format(Date())
            datetext.text = currentDateandTime


        //event list named song list
        var songListed = listOf(
            Event( R.drawable.westviewlogoer , "Therapy Dogs",  "8:30AM - 12:30PM", "Gym", "04/16/2024",  "#F1CA64"),
            Event(imageiD = R.drawable.o16logo , eventName = "All Team Meeting", eventTime = "4:00PM-6:00PM", eventLocation = "ROP Buildings", eventDateTime = "3/27/2024",  color = "#34BEE3"),
            Event(imageiD = R.drawable.speechlogofin , eventName = "All Team Meeting", eventTime = "4:00PM-6:00PM", eventLocation = "Virtual", eventDateTime = "3/27/2024", color = "#725B4E"),
        )

        //sort through list to find events with color matching the org color
        var mylist = ArrayList<Event>()

        for(Event in songListed){
            if(Event.color == contributercolor) {
                mylist.add(Event)
            }
        }



        //pass the even list to the recycler view
        val recView : RecyclerView = findViewById(R.id.recycler)
        recView.layoutManager = LinearLayoutManager(this)
        recView.adapter = EventAdapter(mylist, this)


        //add event button and varaible
        var addevent : Button = findViewById(R.id.eventAddButton)


        var popup : ImageView = findViewById(R.id.popup)
        var eventNamePrompt : TextView = findViewById(R.id.eventNamePrompt)
        var eventNameInput : EditText = findViewById(R.id.eventNameInput)
        var eventTimePrompt : TextView = findViewById(R.id.eventTimePrompt)
        var eventTimeInput : EditText = findViewById(R.id.eventTimeInput)
        var eventLocationPrompt : TextView = findViewById(R.id.eventLocationPrompt)
        var eventLocationInput : EditText = findViewById(R.id.eventLocationInput)
        var mainprompttext : TextView = findViewById(R.id.Prompt)
        var eventDatePrompt : TextView = findViewById(R.id.eventDatePrompt)
        var eventDateInput : EditText = findViewById(R.id.eventDateInput)
        var confirmbutton : Button = findViewById(R.id.Confirm)
        var cancelbutton : Button = findViewById(R.id.cancel)

        popup.setImageResource(R.drawable.contributerframe)
        popup.visibility = (View.GONE)
        eventNamePrompt.visibility = (View.GONE)
        eventNameInput.visibility = (View.GONE)
        eventTimeInput.visibility = (View.GONE)
        eventTimePrompt.visibility = (View.GONE)
        eventLocationInput.visibility = (View.GONE)
        eventLocationPrompt.visibility = (View.GONE)
        mainprompttext.visibility = (View.GONE)
        eventDatePrompt.visibility = (View.GONE)
        eventDateInput.visibility = (View.GONE)
        confirmbutton.visibility = (View.GONE)
        cancelbutton.visibility = (View.GONE)

        //if add event is clicked then boolean is true and certain things are populated on screen
        addevent.setOnClickListener(){
            addingEvent = true;
            if(addingEvent){
                popup.visibility = (View.VISIBLE)
                eventNamePrompt.visibility = (View.VISIBLE)
                eventNameInput.visibility = (View.VISIBLE)
                eventTimeInput.visibility = (View.VISIBLE)
                eventTimePrompt.visibility = (View.VISIBLE)
                eventLocationInput.visibility = (View.VISIBLE)
                eventLocationPrompt.visibility = (View.VISIBLE)
                mainprompttext.visibility = (View.VISIBLE)
                eventDatePrompt.visibility = (View.VISIBLE)
                eventDateInput.visibility = (View.VISIBLE)
                confirmbutton.visibility = (View.VISIBLE)
                cancelbutton.visibility = (View.VISIBLE)

                confirmbutton.setOnClickListener(){
                        var e :  Event =  Event(contributerlogo, eventNameInput.text.toString(), eventTimeInput.text.toString(),  eventLocationInput.text.toString(), eventDateInput.text.toString(), contributercolor)
                //                    Log.d("app", "eventInputText is " + eventNameInput.text.toString())
                    mylist.add(e)
                    popup.visibility = (View.GONE)
                    eventNamePrompt.visibility = (View.GONE)
                    eventNameInput.visibility = (View.GONE)
                    eventTimeInput.visibility = (View.GONE)
                    eventTimePrompt.visibility = (View.GONE)
                    eventLocationInput.visibility = (View.GONE)
                    eventLocationPrompt.visibility = (View.GONE)
                    mainprompttext.visibility = (View.GONE)
                    eventDatePrompt.visibility = (View.GONE)
                    eventDateInput.visibility = (View.GONE)
                    confirmbutton.visibility = (View.GONE)
                    cancelbutton.visibility = (View.GONE)
                }

                cancelbutton.setOnClickListener(){
                    popup.visibility = (View.GONE)
                    eventNamePrompt.visibility = (View.GONE)
                    eventNameInput.visibility = (View.GONE)
                    eventTimeInput.visibility = (View.GONE)
                    eventTimePrompt.visibility = (View.GONE)
                    eventLocationInput.visibility = (View.GONE)
                    eventLocationPrompt.visibility = (View.GONE)
                    mainprompttext.visibility = (View.GONE)
                    eventDatePrompt.visibility = (View.GONE)
                    eventDateInput.visibility = (View.GONE)
                    confirmbutton.visibility = (View.GONE)
                    cancelbutton.visibility = (View.GONE)
                    addingEvent = false
                }

            }

        }



    }
}