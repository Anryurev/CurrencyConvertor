package com.bignerdranch.android.currencyconvertor

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.math.RoundingMode
import java.text.DecimalFormat

class ActivityTwo : AppCompatActivity() {
    companion object{
        const val TOTAL_COUNT = "total_count"
    }
    private lateinit var priceText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_two)
        priceText = findViewById(R.id.price_textView)
        showPrice()
    }

    private fun showPrice(){
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.DOWN
        val price = intent.getDoubleExtra(TOTAL_COUNT, 0.0)
        priceText.text = df.format(price).toString()
    }
}