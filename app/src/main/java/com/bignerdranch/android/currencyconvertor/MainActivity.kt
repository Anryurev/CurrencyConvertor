package com.bignerdranch.android.currencyconvertor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var saleSeekBar:SeekBar
    private lateinit var seekTextView:TextView
    private lateinit var enterTextView:EditText
    private lateinit var calcButton: Button
    private lateinit var dollarRadioButton: RadioButton
    private lateinit var euroRadioButton: RadioButton
    private lateinit var poundRadioButton: RadioButton
    private var sale = 0.0
    private var price = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        saleSeekBar = findViewById(R.id.sale_seekBar)
        seekTextView = findViewById(R.id.seek_textView)
        enterTextView = findViewById(R.id.enter_editText)
        calcButton = findViewById(R.id.calc_button)
        dollarRadioButton = findViewById(R.id.dollar_radioButton)
        euroRadioButton = findViewById(R.id.euro_radioButton)
        poundRadioButton = findViewById(R.id.pound_radioButton)
        saleSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                seekTextView.text = progress.toString()
                sale = (100.0 - progress)/100.0
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })
        calcButton.setOnClickListener{
            if (dollarRadioButton.isActivated){
                price = (enterTextView.text.toString().toDouble() * sale)/75.0
            }
            else if (euroRadioButton.isActivated){
                price = (enterTextView.text.toString().toDouble() * sale)/90.0
            }
            else if (poundRadioButton.isActivated){
                price = (enterTextView.text.toString().toDouble() * sale)/100.0
            }
        }
    }
}