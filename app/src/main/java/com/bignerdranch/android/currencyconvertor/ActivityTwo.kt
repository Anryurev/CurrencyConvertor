package com.bignerdranch.android.currencyconvertor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.math.RoundingMode
import java.text.DecimalFormat

class ActivityTwo : AppCompatActivity() {
    val price = intent.getStringExtra("Price")
    private lateinit var priceTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        priceTextView = findViewById(R.id.price_textView)
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        priceTextView.setText(df.format(price).toString())
    }
}