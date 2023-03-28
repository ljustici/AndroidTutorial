package com.ljusticia.androidtutorial.todoapp

sealed class TaskCategory(var isSelected: Boolean = true){

    //el atributo isSelected se aplica a cada objeto

    object Personal:TaskCategory()
    object Business:TaskCategory()
    object Other:TaskCategory()
}