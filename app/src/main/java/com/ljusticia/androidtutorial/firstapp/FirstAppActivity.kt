package com.ljusticia.androidtutorial.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.ljusticia.androidtutorial.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        //botón
        val btStart = findViewById<AppCompatButton>(R.id.btStart)

        //EditText
        val etName = findViewById<AppCompatEditText>(R.id.etName)

        btStart.setOnClickListener {
            Log.i("ljustici","Botón pulsado ${etName.text.toString()}") //Muestra mensaje en logcat

        }



        //Al arrancar la pantalla
    }
}