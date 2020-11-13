package com.example.madmadworld

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat

class BirthdayActivity : AppCompatActivity() {
    lateinit var calendarView: CalendarView
    lateinit var dateView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_birthday)
        findViewById<Button>(R.id.submitBtn).setOnClickListener { calendar() }

        calendarView = findViewById(R.id.myDate)
        dateView = findViewById(R.id.dateView)

        calendarView.setOnDateChangeListener {view, year, month, dayOfMonth ->
            val date = dayOfMonth.toString() + "−" + (month + 1) + "−" + year
            val selectedDate = "2002"
            calendarView.setDate(SimpleDateFormat("yyyy").parse(selectedDate).time, true, true)
            dateView.text = date
        }
    }
    private fun calendar() {

        val dateView = findViewById<TextView>(R.id.dateView)
        val bornday = dateView.text.toString()

        val s = intent.extras
        val Firstname = s!!.getString("First Name")
        val Lastname = s!!.getString("Last Name")
        val email = s!!.getString("Email")
        val phoneNum = s!!.getString("Phone Number")
        val age = s!!.getString("")


        val intent = Intent(this, DisplayActivity::class.java)
        intent.putExtra("First Name", Firstname)
        intent.putExtra("Last Name", Lastname)
        intent.putExtra("Email", email)
        intent.putExtra("Phone Number",phoneNum)
        intent.putExtra("",age)
        intent.putExtra("Birth date",bornday)
        startActivity(intent)
    }



}


