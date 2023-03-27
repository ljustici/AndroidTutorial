package com.ljusticia.androidtutorial.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ljusticia.androidtutorial.R
import com.ljusticia.androidtutorial.todoapp.TaskCategory.*


class TodoActivity : AppCompatActivity() {

    //Si importas TaskCategory ya no tienes que escribir TaskCategory.Business,etc.
    private val categories = listOf(
        Business,
        Personal,
        Other
    )

    //Es mutable porque va a cambiar
    private val tasks = mutableListOf(
        Task("PruebaBusiness", Business),
        Task("PruebaPersonal", Personal),
        Task("PruebaOther", Other)
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks: RecyclerView
    private lateinit var tasksAdapter: TasksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponents()
        initUI()
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
    }

    private fun initUI() {
        //Adapter: Clase que conecta toda la información con el RecyclerView
        //ViewHolder: Clase que pinta el RecyclerView

        categoriesAdapter = CategoriesAdapter(categories)
        //Se encarga de que el layout sea vertical u horizontal
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks)

        //el vertical es por defecto y no necesita más parámetros
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
    }

}