package com.ljusticia.androidtutorial.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            val name = etName.text.toString()

            if (name.isNotEmpty()){
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("EXTRA NAME", name)
                startActivity(intent)
            }
        }



        //Al arrancar la pantalla
    }
}