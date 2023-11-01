package com.example.mad_project_106

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAge = findViewById<Button>(R.id.btnAge)
        val btnGST = findViewById<Button>(R.id.btnGST)

        btnAge.setOnClickListener {
            val intent = Intent(this, AgeCalculate::class.java)
            startActivity(intent)
        }

        btnGST.setOnClickListener {
            val intent = Intent(this, GstCalculate::class.java)
            startActivity(intent)
        }
    }
}
