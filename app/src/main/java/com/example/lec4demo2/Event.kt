package com.example.lec4demo2

 class Event () {
     var imageiD: Int = 0
     var eventName: String = "default"
     var eventTime: String = "default"
     var eventLocation: String = "default"
     var eventDateTime: String = "default"
     var color: String = "default"

     constructor(imageiD: Int, eventName: String,  eventTime : String, eventLocation : String, eventDateTime: String, color : String,) : this(){
         this.imageiD = imageiD
         this.eventName = eventName
         this.eventTime = eventTime
         this.eventLocation = eventLocation
         this.eventDateTime = eventDateTime
         this.color = color
     }


 }





