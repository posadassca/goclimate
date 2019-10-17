package com.example.instantclimate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Cities : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val TAG = "com.example.instantclimate.cities.CITY"

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)

        val bMexico = findViewById<Button>(R.id.bMexico)
        val bArgentina = findViewById<Button>(R.id.bArgentina)

        bMexico.setOnClickListener {
            val intentCordoba = Intent(this, MainActivity::class.java) //Intent explícito (Key, Value)
            intentCordoba.putExtra(TAG, "3836277")
            startActivity(intentCordoba)
        }

        bArgentina.setOnClickListener{
            val intentBuenosAires = Intent(this, MainActivity::class.java) //Intent explícito
            intentBuenosAires.putExtra(TAG, "3435910")
            startActivity(intentBuenosAires)
        }
    }
}
