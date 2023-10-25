package com.bignerdranch.android.currencyconvertor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var saleSeekBar:SeekBar
    private lateinit var seekTextView:TextView
    private lateinit var radioGroup:RadioGroup
    private lateinit var enterTextView:EditText
    private lateinit var calcButton: Button
    private lateinit var dollarRadioButton: RadioButton
    private lateinit var euroRadioButton: RadioButton
    private lateinit var poundRadioButton: RadioButton
    private var sale = 1.0
    private var price = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        saleSeekBar = findViewById(R.id.sale_seekBar)
        seekTextView = findViewById(R.id.seek_textView)
        enterTextView = findViewById(R.id.enter_editText)
        radioGroup = findViewById(R.id.radio_group)
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

        radioGroup.setOnCheckedChangeListener{ _, checkedId ->
            if (enterTextView.text.length > 0){
                calcButton.isEnabled=true
            }
        }

        fun getPrice() {
            val intent = Intent(this,ActivityTwo::class.java)

            if (dollarRadioButton.isChecked){
                price = enterTextView.text.toString().toDouble()/(75.0 * sale)
            }
            else if (euroRadioButton.isChecked){
                price = enterTextView.text.toString().toDouble()/(90.0 * sale)
            }
            else if (poundRadioButton.isChecked){
                price = enterTextView.text.toString().toDouble()/(100.0 * sale)
            }

            intent.putExtra(ActivityTwo.TOTAL_COUNT, price)

            startActivity(intent)
        }

        calcButton.setOnClickListener{
            getPrice()
        }
    }
}