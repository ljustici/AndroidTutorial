package com.ljusticia.androidtutorial.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
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

    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponents()
        initUI()
        initListeners()
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener {showDialog()}
    }

    private fun showDialog(){
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)

        //Inicializar botón del dialog
        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)

        //Inicializar EditText del dialog
        val etTask: EditText = dialog.findViewById(R.id.etTask)

        //Inicializar RadioGroup del dialog
        val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)

        //Capturar radio button seleccionado y texto escrito cuando se pulsa el botón
        btnAddTask.setOnClickListener{
            val currentTask = etTask.text.toString()
            if (currentTask.isNotEmpty()){
                val selectedId = rgCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton = rgCategories.findViewById(selectedId)
                val currentCategory:TaskCategory = when(selectedRadioButton.text){
                    getString(R.string.todo_dialog_category_business) -> Business
                    getString(R.string.todo_dialog_category_personal) -> Personal
                    else -> Other
                }

                tasks.add(Task(currentTask, currentCategory))
                updateTasks()
                dialog.hide()
            }
        }

    }

    //Cuando se pulse el item se pone a verdadero o a falso
    private fun onItemSelected(position:Int){
        tasks[position].isSelected = !tasks[position].isSelected
    }
    private fun updateTasks(){
        //Guardar en esta lista todas las categorías seleccionadas
        val selectedCategories : List<TaskCategory> = categories.filter { it.isSelected }

        //Guardar en esta lista todas las tasks cuya categoría es una categoría seleccionada
        var selectedTasks = tasks.filter{selectedCategories.contains(it.category)}

        //Ahora este es el nuevo listado para el Adapter
        tasksAdapter.tasks = selectedTasks

        //Notifica al Adapter que el listado ha cambiado
        tasksAdapter.notifyDataSetChanged()
    }

    private fun updateCategories(position: Int){
        //Cambiar el atributo isSelected de la categoría que se toque
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter.notifyItemChanged(position)

        //Filtrar a las tasks cuya categoría corresponde con la que se ha tocado
        updateTasks()
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)
    }

    private fun initUI() {
        //Adapter: Clase que conecta toda la información con el RecyclerView
        //ViewHolder: Clase que pinta el RecyclerView

        categoriesAdapter = CategoriesAdapter(categories){position->updateCategories(position)}
        //Se encarga de que el layout sea vertical u horizontal
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        //Se inicializa el adaptador con la lista y la función lambda necesarios para leer
        //los datos y actualizarlos cuando el usuario toque un item
        tasksAdapter = TasksAdapter(tasks ) {onItemSelected(it)}// =position->onItemSelected(position)

        //el vertical es por defecto y no necesita más parámetros
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter

    }

}