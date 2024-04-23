package com.example.lec4demo2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Calendar
import java.util.Date
import java.util.Locale


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

//      Background Image Implementation and Scale
        val background : ImageView = findViewById(R.id.background)
        background.setImageResource(R.drawable.homebackground)
        background.scaleX = 1.3F

//      images frame
        var frame : ImageView = findViewById(R.id.imageView2)
        frame.setImageResource(R.drawable.eventsframe)

        //TEXT FOR DATE, Format
        val datetext : TextView = findViewById(R.id.dateTextView)
        val sdf = SimpleDateFormat("MMMM dd,  yyyy", Locale.getDefault())
        val currentDateandTime: String = sdf.format(Date())
        datetext.text =currentDateandTime

        //event list named song list
        var songListed = listOf(
            Event( R.drawable.westviewlogoer , "Therapy Dogs",  "8:30AM - 12:30PM", "Gym", "04/17/2024",  "#F1CA64"),
            Event(R.drawable.o16logo ,  "All Team Meeting","4:00PM-6:00PM", "ROP Buildings", "04/17/2024",  "#34BEE3"),
            Event( R.drawable.speechlogofin , "All Team Meeting",  "4:00PM-6:00PM", "Virtual",  "03/27/2024", "#725B4E"),
        )

//      DATE FOR COMPARISON
        val cdf =  SimpleDateFormat("MM/dd/yyyy")
        val c : Calendar = Calendar.getInstance()
        val comparisondate: String = cdf.format(c.time)
        Log.d("app", "date comapred to is " + comparisondate)



//      Sort through the list and only populate with event happeneing on a given date
        var mylist = ArrayList<Event>()

        for(Event in songListed){
//            Log.d("app", "date being compared is" + Event.eventDateTime)
            if(Event.eventDateTime==(comparisondate)) {
                mylist.add(Event)

            }
        }

//      pass the event list to the recycler view
        val recView : RecyclerView = findViewById(R.id.recycler)
        recView.layoutManager = LinearLayoutManager(this)
        recView.adapter = EventAdapter(mylist, this)


//      switch to contributer view for debugg
        val switchbutton : Button = findViewById(R.id.button)
        switchbutton.setOnClickListener{
            var intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }



        //popup decs and NOT VISIBLE

        var popup : ImageView = findViewById(R.id.popup)
        var eventNamePrompt : TextView = findViewById(R.id.eventNamePrompt)
        var eventNameInput : EditText = findViewById(R.id.eventNameInput)
        var eventTimePrompt : TextView = findViewById(R.id.eventTimePrompt)
        var eventTimeInput : EditText = findViewById(R.id.eventTimeInput)
        var eventLocationPrompt : TextView = findViewById(R.id.eventLocationPrompt)
        var eventLocationInput : EditText = findViewById(R.id.eventLocationInput)
        var eventDatePrompt : TextView = findViewById(R.id.eventDatePrompt)
        var eventDateInput : EditText = findViewById(R.id.eventDateInput)
        var mainprompttext : TextView = findViewById(R.id.Prompt)
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



    }
}