package com.ljusticia.androidtutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ljusticia.androidtutorial.firstapp.FirstAppActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btSaludapp = findViewById<Button>(R.id.btSaludapp)

        btSaludapp.setOnClickListener{ navigateToSaludapp()}
    }

    private fun navigateToSaludapp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }
}