package com.ljusticia.androidtutorial.todoapp

data class Task (val name: String, val Category: TaskCategory, var isSelected:Boolean = false){
}