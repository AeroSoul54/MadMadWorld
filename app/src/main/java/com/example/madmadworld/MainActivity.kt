package com.example.madmadworld


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.nextBtn).setOnClickListener { getInfo() }
//switch function
        val phoneNum = findViewById<EditText>(R.id.phoneEntry)
        val switch = findViewById<Switch>(R.id.switch1)
        switch?.setOnCheckedChangeListener(object: CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
                if(isChecked)
                    phoneNum.setVisibility(View.VISIBLE);
                else
                    phoneNum.setVisibility(View.INVISIBLE)

            }
        })
        //seekbar

        val seekBar = findViewById<SeekBar>(R.id.seekBar)
        val age = findViewById<TextView>(R.id.ageTv)

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, i: Int, fromUser: Boolean) {
                if (i<18)
                    age.text="Age:18"
                else if (i>60)
                    age.text = "Age:60"
                else
                    age.text = "Age:$i"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

private fun getInfo(){
    val firstnameEntry = findViewById<EditText>(R.id.firstNameEntry)
    val lastNameEntry = findViewById<EditText>(R.id.lastNameEntry)
    val emailEntry = findViewById<EditText>(R.id.emailEntry)
    val phoneEntry = findViewById<EditText>(R.id.phoneEntry)
    val ageTv = findViewById<TextView>(R.id.ageTv)

    val Firstname =firstnameEntry.text.toString()
    val Lastname =lastNameEntry.text.toString()
    val email =emailEntry.text.toString()
    val phone = phoneEntry.text.toString()
    val age = ageTv.text.toString()


    val intent = Intent(this, BirthdayActivity::class.java)
    intent.putExtra("First Name", Firstname)
    intent.putExtra("Last Name", Lastname)
    intent.putExtra("Email",email)
    intent.putExtra("Phone Number",phone)
    intent.putExtra("",age)
    startActivity(intent)
}



}