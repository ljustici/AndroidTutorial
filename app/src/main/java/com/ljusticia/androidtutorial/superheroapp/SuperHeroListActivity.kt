package com.ljusticia.androidtutorial.superheroapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.ljusticia.androidtutorial.R
import com.ljusticia.androidtutorial.databinding.ActivitySuperHeroListBinding
import com.ljusticia.androidtutorial.superheroapp.DetailSuperheroActivity.Companion.EXTRA_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SuperHeroListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: SuperheroAdapter

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
        })

        adapter= SuperheroAdapter(){navigateToDetail(it)}
        binding.rvSuperhero.setHasFixedSize(true)
        binding.rvSuperhero.layoutManager = LinearLayoutManager(this)
        binding.rvSuperhero.adapter = adapter
    }

    private fun searchByName(query: String) {
        //lanza una corutina en un hilo secundario para peticiones de red, guardar en bbdd, y cosas

        //Muestra el circulito de que se está buscando
        binding.progressBar.isVisible =true

        //en las que tenga que pensar mucho ---> IO
        CoroutineScope(Dispatchers.IO).launch {
            //Esto ocurre en un hilo secundario

            //Con retrofit crea la interfaz ApiService y busca el valor de query
            val myResponse = retrofit.create(ApiService::class.java).getSuperheroes(query)
            if (myResponse.isSuccessful) {
                Log.i("ljustici", "Funciona")
                val response: SuperHeroDataResponse? = myResponse.body()
                if (response != null)
                {
                    Log.i("ljustici", response.toString())
                    runOnUiThread{
                        adapter.updateList(response.superheroes)
                        binding.progressBar.isVisible =false
                    }
                }

            }
                else
                Log.i("ljustici", "No funciona")
        }
    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://superheroapi.com/") //!!acabar url en /
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun navigateToDetail(id:String){
        val intent = Intent(this, DetailSuperheroActivity::class.java)
        intent.putExtra(EXTRA_ID, id)
        startActivity(intent)
    }
}