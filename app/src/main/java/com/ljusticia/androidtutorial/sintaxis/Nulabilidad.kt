package com.ljusticia.androidtutorial

fun main() {
    var name:String? = null

    println(name?.get(3)) //si no es nulo imprime la posición 4
    println(name!!.get(3)) //indico que no es nulo y que imprima la posición 4 (si es nulo error)
    println(name?.get(3) ?: "Es nulo") //Si no es nulo imprime posición 4, si lo es imprime msg
}