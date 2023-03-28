package com.ljusticia.androidtutorial.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.ljusticia.androidtutorial.R
import com.ljusticia.androidtutorial.databinding.ActivitySuperHeroListBinding
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        retrofit = getRetrofit()
        initUI()
    }

    private fun initUI() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener
            {
                //Cuando se envia el texto
                override fun onQueryTextSubmit(query: String?): Boolean {
                    //query es un parámetro que puede ser nulo, por ello .orEmpty() para evitar
                    //enviar un null a la funcion searchByName
                    searchByName(query.orEmpty())
                    return false
                }

                //Cuando el texto cambia
                override fun onQueryTextChange(newText: String?)=false

            }
        )
    }

    private fun searchByName(query: String) {

    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://superheroapi.com/") //!!acabar url en /
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}