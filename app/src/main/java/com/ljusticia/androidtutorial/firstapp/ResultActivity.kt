package com.ljusticia.androidtutorial.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.ljusticia.androidtutorial.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult = findViewById<TextView>(R.id.tvResult)

        //Dame la String o el vacío que contenga la key "EXTRA NAME"
        val name:String = intent.extras?.getString("EXTRA NAME").orEmpty()
        tvResult.text = "Hola $name"
    }
}