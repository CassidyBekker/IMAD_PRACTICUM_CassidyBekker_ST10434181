package com.example.my_imad_practicum

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView

class DetailedView : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)


        val tableLayout = findViewById<TableLayout>(R.id.TableLayout)
        val buttonBack = findViewById<Button>(R.id.ButtonBack)

        val screenData = intent.getSerializableExtra("screenData") as ArrayList<ScreenDataEntry>

        if (screenData != null) {
            populateSummaryTable(tableLayout, screenData)
        }

        buttonBack.setOnClickListener {
            val intent = Intent(this, MScreen::class.java)
            startActivity(intent)

        }

    }

    private fun populateSummaryTable(tableLayout: TableLayout, screenData: List<ScreenDataEntry>) {
        // Adding headings to the table
        val headerRow = TableRow(this)
        headerRow.addView(createTextView("Day"))
        headerRow.addView(createTextView("Min"))
        headerRow.addView(createTextView("Max"))
        headerRow.addView(createTextView("Weather-conditions"))
        tableLayout.addView(headerRow)


        screenData.forEach { entry ->

            val row = TableRow(this)
            row.addView(createTextView(entry.day))
            row.addView(createTextView(entry.min.toString()))
            row.addView(createTextView(entry.max.toString()))
            row.addView(createTextView(entry.weatherConditions))
            tableLayout.addView(row)

        }

    }


    private fun createTextView(text: String): TextView {
        val TableView = TextView(this)
        TableView.text = text
        return TableView

    }

}
