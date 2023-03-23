package com.ljusticia.androidtutorial

fun main() {
    inmutableList()
}

fun mutableList(){
    val weekDays:MutableList<String> = mutableListOf("Lunes", "Martes", "Miércoles")
    //mutableListOf() puede estar vacío, si le das valor son valores por defecto

    weekDays.add("Jueves") //se añade al final
    print(weekDays)

    weekDays.add(0,"Domingo") //Se añade delante de Lunes

    if (weekDays.isNotEmpty())
        weekDays.forEach{println(it)}
}

fun inmutableList(){
    val readOnly:List<String> = listOf("Lunes", "Martes", "Miércoles")

    println(readOnly.size)
    println(readOnly)
    println(readOnly[0])
    println(readOnly.last())

    val example = readOnly.filter{it.contains("M")}
    println(example)

    readOnly.forEach{println(it)}

    readOnly.forEach{weekDay -> println(weekDay)} //igual que anterior pero más legible
}