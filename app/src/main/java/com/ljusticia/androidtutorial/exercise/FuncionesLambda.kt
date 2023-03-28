package com.ljusticia.androidtutorial.exercise

fun main() {
    ejecutarLambda (saludar)
    ejecutarLambda2(saludarNombre)
    ejecutarLambda3 (sumarDiez)
}

//() no recibe nada
//->Unit tipo unit
val saludar:() ->Unit = {println("Hola Mundo")} // val saludar = {println("Hola Mundo")}

val saludarNombre: (String) ->Unit = {name:String->println("Hola $name")}

val sumarDiez:(Int)->Int = {numero:Int->numero+10}

fun ejecutarLambda(funcionLambda:()->Unit){
    funcionLambda()
}

fun ejecutarLambda2(funcionLambda:(a:String)->Unit){
    funcionLambda("María")
}

fun ejecutarLambda3(funcionLambda:(a:Int)->Int){
    val resultado = funcionLambda(40)
    println("el resultado es $resultado")
}