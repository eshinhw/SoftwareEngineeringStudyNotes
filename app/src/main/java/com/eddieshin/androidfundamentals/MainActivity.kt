package com.eddieshin.androidfundamentals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.practice_constraint_layout.*
import kotlinx.android.synthetic.main.practice_edittext.*
import kotlinx.android.synthetic.main.practice_intent.*
import kotlinx.android.synthetic.main.practice_textview.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        // setContentView(R.layout.practice_linearlayout) // R represents resources (res folder)
        // textViewCount() // textView Practice
        // practiceEditText()
        // practiceIntent()

        // Intent
        setContentView(R.layout.practice_intent)
        btnSubmit.setOnClickListener {
            val name = etName.text.toString()
            val age = etAge.text.toString().toInt()
            val origin = etOrigin.text.toString()
            val person = Person(name, age, origin)
            val intent = Intent(this, SubActivity::class.java)
            intent.putExtra("EXTRA_PERSON", person)
            startActivity(intent)

        }
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
        setContentView(R.layout.practice_edittext)

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

    fun practiceIntent() {
        setContentView(R.layout.practice_intent)


    }
}