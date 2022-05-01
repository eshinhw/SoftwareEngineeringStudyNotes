package com.eddieshin.androidfundamentals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sub.*

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        val person = intent.getSerializableExtra("EXTRA_PERSON") as Person
        val name = person.name
        val age = person.age
        val origin = person.origin
        val personString = "$name is $age years old and lives in $origin"

        tvPerson.text = personString

        btnGoToMain.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}