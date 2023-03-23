package com.ljusticia.androidtutorial

fun main(){
    val weekDays = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes")

    println(weekDays.size)

    weekDays[0] = "Hola"
    weekDays[8] = "A" //no funciona porque no existe la posición 8

    for (position in weekDays.indices)
    {
        println(weekDays[position])
    }

    for ((position, value) in weekDays.withIndex()){
        println("La posición $position contiene $value")
    }

    for (weekDay in weekDays){
        println("Ahora es $weekDay")
    }
}