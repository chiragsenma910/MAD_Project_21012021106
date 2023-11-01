package com.example.mad_project_106

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GstCalculate : AppCompatActivity() {
        private lateinit var edtAmount: EditText
        private lateinit var btnCalculateGST: Button
        private lateinit var tvGSTResult: TextView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_gst_calculate)

            edtAmount = findViewById(R.id.edtAmount)
            btnCalculateGST = findViewById(R.id.btnCalculateGST)
            tvGSTResult = findViewById(R.id.tvGSTResult)

            btnCalculateGST.setOnClickListener {
                calculateGST()
            }
        }

        private fun calculateGST() {
            val amountText = edtAmount.text.toString()
            if (amountText.isNotEmpty()) {
                try {
                    val amount = amountText.toDouble()
                    // Assuming GST rate is 18%
                    val gstRate = 0.18
                    val gstAmount = amount * gstRate
                    val totalAmount = amount + gstAmount
                    tvGSTResult.text = "GST Amount: $gstAmount\nTotal Amount (including GST): $totalAmount"
                } catch (e: NumberFormatException) {
                    tvGSTResult.text = "Invalid input. Please enter a valid amount."
                }
            } else {
                tvGSTResult.text = "Please enter an amount."
            }
        }
    }

