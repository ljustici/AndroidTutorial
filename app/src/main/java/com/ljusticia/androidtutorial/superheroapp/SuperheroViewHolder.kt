package com.ljusticia.androidtutorial.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ljusticia.androidtutorial.databinding.ItemSuperheroBinding
import com.squareup.picasso.Picasso

class SuperheroViewHolder(view: View):RecyclerView.ViewHolder(view){

    private val binding = ItemSuperheroBinding.bind(view)

    fun bind(superheroItemResponse: SuperheroItemResponse, onItemSelected: (String) -> Unit){
        binding.tvSuperheroName.text = superheroItemResponse.name

        Picasso.get().load(superheroItemResponse.superheroImage.url).into(binding.ivSuperhero)

        //root: toda la página
        binding.root.setOnClickListener{onItemSelected(superheroItemResponse.superheroId)}

    }
}