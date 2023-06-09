package com.ljusticia.androidtutorial.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ljusticia.androidtutorial.R

class CategoriesAdapter(private var categories: List<TaskCategory>, private val onItemSelected: (Int) -> Unit) :
    RecyclerView.Adapter<CategoriesViewHolder>() {

    //Crea la vista que el método Bind rellenará de datos
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent,false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(categories[position], onItemSelected) //se le manda la función onItemSelected como parámetro
    }

    //devuelve el número de categorías en la lista
    override fun getItemCount() = categories.size

}