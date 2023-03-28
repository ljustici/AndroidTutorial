package com.ljusticia.androidtutorial

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.ljusticia.androidtutorial.firstapp.FirstAppActivity
import com.ljusticia.androidtutorial.imccalculator.ImcCalculatorActivity
import com.ljusticia.androidtutorial.superheroapp.SuperHeroListActivity
import com.ljusticia.androidtutorial.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        //SALUDApp
        val btSaludapp = findViewById<Button>(R.id.btSaludapp)
        btSaludapp.setOnClickListener{ navigateToSaludapp()}

        //IMC App
        val btImcApp = findViewById<Button>(R.id.btIMCApp)
        btImcApp.setOnClickListener{ navigateToImcApp()}

        //TODO App
        val btTodoApp = findViewById<Button>(R.id.btTodoApp)
        btTodoApp.setOnClickListener{ navigateToTodoApp()}

        //Superhero App
        val btSuperhero = findViewById<Button>(R.id.btSuperhero)
        btSuperhero.setOnClickListener{navigatoToSuperheroApp()}
    }

    private fun navigateToTodoApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludapp(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToImcApp(){
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigatoToSuperheroApp() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }

}