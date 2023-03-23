package com.ljusticia.androidtutorial

fun main() {

}

fun getMonth(month:Int):String {
    var result = when(month){
        1 -> "Enero"
        2 -> {
            "febrero"
            "febrero"
        }
        4, 5, 6 -> "Otros"
        in 7..12 -> "Rango mayor"
        !in 1..12 -> "no es válido"
        else -> "No es válido"
    }
    return result
}

fun getMonth2(month:Int):String {
    return when(month){
        1 -> "Enero"
        2 -> {
            "febrero"
            "febrero"
        }
        4, 5, 6 -> "Otros"
        in 7..12 -> "Rango mayor"
        !in 1..12 -> "no es válido"
        else -> "No es válido"
    }
}

fun getMonth3(month:Int) = when(month){
        1 -> "Enero"
        2 -> {
            "febrero"
            "febrero"
        }
        4, 5, 6 -> "Otros"
        in 7..12 -> "Rango mayor"
        !in 1..12 -> "no es válido"
        else -> "No es válido"
    }

fun result(value:Any) {
    when(value){
        is Int -> value + value
        is String -> println(value)
        is Boolean -> if (value) println("It's true")
    }
}