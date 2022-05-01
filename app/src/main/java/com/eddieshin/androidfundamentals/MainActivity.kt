package com.eddieshin.androidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.et_calculator.*
import kotlinx.android.synthetic.main.practice_constraint_layout.*
import kotlinx.android.synthetic.main.practice_textview.*
import kotlinx.android.synthetic.main.textview_practice.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.practice_linearlayout) // R represents resources (res folder)
        // textViewCount() // textView Practice
        practiceEditText()
    }

    fun practiceConstraintLayout() {
        setContentView(R.layout.practice_constraint_layout)

        val btnApply = findViewById<Button>(R.id.btnApply)
        btnApply.setOnClickListener {
            val firstName = etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val birthDate = etBirthDate.text.toString()
            val country = etCountry.text.toString()
            Log.d("MainActivity", "$firstName $lastName was born on $birthDate in $country")
        }
    }

    fun practiceTextView() {
        setContentView(R.layout.practice_textview)
        var count = 0
        btnIncrease.setOnClickListener {
            count ++
            val newText = "Let's Count Clicks! +$count"
            tvCount.text = newText
        }
    }

    fun practiceEditText() {
        setContentView(R.layout.et_calculator)

        btnAdd.setOnClickListener {
            val firstNum = etFirstNumber.text.toString().toInt()
            val secondNum = etSecondNumber.text.toString().toInt()
            val newText = "Result: ${firstNum + secondNum}"
            tvResult.text = newText

        }
    }

    fun practiceImageView() {
        setContentView(R.layout.practice_imgview)
    }

    fun practiceCheckBox() {
        setContentView(R.layout.practice_checkbox)
    }
}