package com.example.lec4demo2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        val cardUserView : CardView = findViewById(R.id.card_user_button)
        val cardContributorView : CardView = findViewById(R.id.card_contributor_button)

        cardUserView.setOnClickListener{
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        cardContributorView.setOnClickListener{
            val conIntent = Intent(this,MainActivity::class.java)
            startActivity(conIntent)
        }

    }

}