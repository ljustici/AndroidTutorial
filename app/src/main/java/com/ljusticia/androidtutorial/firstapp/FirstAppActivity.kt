package com.ljusticia.androidtutorial.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ljusticia.androidtutorial.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        //Al arrancar la pantalla
    }
}