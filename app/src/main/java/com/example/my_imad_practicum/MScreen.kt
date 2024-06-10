package com.example.my_imad_practicum

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
// creating a class and private functions.
class MScreen : AppCompatActivity() {
    private lateinit var WeekDayInput: EditText
    private lateinit var MinTempInput: EditText
    private lateinit var MaxTempInput: EditText
    private lateinit var WeatherConditionInput: EditText
    private val screenData = mutableListOf<ScreenDataEntry>()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mscreen)

// Declaring all values that will be needed in the below codes

        WeekDayInput = findViewById(R.id.WeekDayInput)
        MinTempInput = findViewById(R.id.MinTempInput)
        MaxTempInput  = findViewById(R.id.MaxTempInput)
        WeatherConditionInput = findViewById(R.id.WeatherConInput)

        val Avgbutton = findViewById<Button>(R.id.AvgButton)
        val ClearButton = findViewById<Button>(R.id.ClearButton)
        val Detailsbutton = findViewById<Button>(R.id.Detailsbutton)
        val Backbutton = findViewById<Button>(R.id.Exit2)
        val AvgOutput = findViewById<TextView>(R.id.AvgOutput)
        val Adddata = findViewById<Button>(R.id.AddButton)


// Declaring the button usuage and will be used in a later fun
        Avgbutton.setOnClickListener{
            calculateAverage()

        }
// The clear button will clear all user inputs as well as the average output
        ClearButton.setOnClickListener {
            clearInputFields()
            AvgOutput.text = ""
        }

// Goes back to first page
        Backbutton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        Adddata.setOnClickListener {
            addScreenData()
        }
// Goes to the next page for detailed version
        Detailsbutton.setOnClickListener {
            val intent = Intent(this, DetailedView::class.java)
            intent.putExtra("screenData", ArrayList(screenData))
            startActivity(intent)
        }

    }
// Working in separate functions

    // Code to calculate the average temp
    private fun calculateAverage() {
        val min = MinTempInput.text.toString().toIntOrNull() ?: 0
        val max = MaxTempInput.text.toString().toIntOrNull() ?: 0
        val average = (min + max) / 2.0
        val AvgOutput: TextView = findViewById(R.id.AvgOutput)
        AvgOutput.text = "Average: $average"

    }
// Adds the user input to an array
    private fun addScreenData() {
        val Day = WeekDayInput.text.toString()
        val Min = MinTempInput.text.toString().toIntOrNull() ?: 0
        val Max = MaxTempInput.text.toString().toIntOrNull() ?: 0
        val WeatherConditionInput = WeatherConditionInput.text.toString()

        if (Day.isNotEmpty() && (Min > 0 || Max > 0)) {
            val entry = ScreenDataEntry(
                day = Day,
                min = Min,
                max = Max,
                weatherConditions = WeatherConditionInput
            )
            screenData.add(entry)
            clearInputFields()

            // Error handling message
            Toast.makeText(this, "Data Entry Successful", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Data in not entered correctly, please retry.", Toast.LENGTH_LONG).show()
        }
    }
// Code to clear all user inputs at the same time
    private fun clearInputFields() {
        WeekDayInput.text.clear()
        MinTempInput.text.clear()
        MaxTempInput.text.clear()
        WeatherConditionInput.text.clear()
    }

}
