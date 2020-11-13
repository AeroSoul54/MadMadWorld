package com.example.madmadworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DisplayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_showinfo)

        val intent = intent
        val Firstname = intent.getStringExtra("First Name")
        val Lastname = intent.getStringExtra("Last Name")
        val email = intent.getStringExtra("Email")
        val phone = intent.getStringExtra("Phone Number")
        val age =  intent.getStringExtra("")
        val bornday = intent.getStringExtra("Birth date")
        //textview
        val infoTextView = findViewById<TextView>(R.id.infoTv)
        //setText
        infoTextView.text = "Name: "+Firstname+"\nLast Name: "+Lastname+"\n "+age+"\nBirth date: "+bornday+"\nEmail: "+email+"\nPhone Number: "+phone

    }
}