package com.example.my_imad_practicum

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declaring all values for buttons
        val Exitbutton = findViewById<Button>(R.id.Exitbutton)
        val Nextbutton = findViewById<Button>(R.id.NextButton)


        // Coding button to go to next page
        Nextbutton.setOnClickListener {
            val intent = Intent(this, MScreen::class.java)

            startActivity(intent)
        }
        Exitbutton.setOnClickListener {

            finish() }
    }
}