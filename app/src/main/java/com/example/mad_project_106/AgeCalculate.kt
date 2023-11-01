package com.example.mad_project_106

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.Calendar

class AgeCalculate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_age_calculate)

        val button = findViewById<Button>(R.id.button1)
        button.setOnClickListener { view ->
            printAge(view)
        }

    }

    private fun printAge(view: View) {
        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, month, day ->
                val selectedDate = "$day/${month + 1}/$year"

                val textView1 = findViewById<TextView>(R.id.textView1)
                textView1.text = selectedDate

                val dob = Calendar.getInstance()
                dob.set(year, month, day)

                // Calculate age
                val currentTime = Calendar.getInstance()
                val age = currentTime.get(Calendar.YEAR) - dob.get(Calendar.YEAR)

                // Calculate total days, months, and weeks
                val timeDifferenceInMillis = currentTime.timeInMillis - dob.timeInMillis
                val totalDays = (timeDifferenceInMillis / (24 * 60 * 60 * 1000)).toInt()
                val totalMonths = (age * 12) + (currentTime.get(Calendar.MONTH) - dob.get(Calendar.MONTH))
                val totalWeeks = totalDays / 7
                val totalHours = (timeDifferenceInMillis / (60 * 60 * 1000)).toInt()
                val totalMinutes = (timeDifferenceInMillis / (60 * 1000)).toInt()

                val textView2 = findViewById<TextView>(R.id.textView2)
                textView2.text = "You are $age years old."


                // Update the newly added TextViews

                val textViewHours = findViewById<TextView>(R.id.textViewHours)
                textViewHours.text = "Total Hours: $totalHours"

                val textViewMinutes = findViewById<TextView>(R.id.textViewMinutes)
                textViewMinutes.text = "Total Minutes: $totalMinutes"
                val textViewDays = findViewById<TextView>(R.id.textViewDays)
                textViewDays.text = "Total Days: $totalDays"

                val textViewMonths = findViewById<TextView>(R.id.textViewMonths)
                textViewMonths.text = "Total Months: $totalMonths"

                val textViewWeeks = findViewById<TextView>(R.id.textViewWeeks)
                textViewWeeks.text = "Total Weeks: $totalWeeks"
            },
            year,
            month,
            day
        ).show()
    }
}