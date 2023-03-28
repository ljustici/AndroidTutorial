package com.ljusticia.androidtutorial.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ljusticia.androidtutorial.R

//private val onTaskSelected: (Int) -> Unit)
// (Int) significa que devuelve un Int,
// -> Unit significa que es una función lambda
//sirve para controlar si el item está seleccionado o no

class TasksAdapter(var tasks: List<Task>, private val onTaskSelected: (Int) -> Unit) :
    RecyclerView.Adapter<TasksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task, parent, false)
        return TasksViewHolder(view)
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.render(tasks[position])
        //Cuando se pulse la view de un item se actualiza a si está seleccionado o no
        holder.itemView.setOnClickListener{onTaskSelected(position)}
    }

}