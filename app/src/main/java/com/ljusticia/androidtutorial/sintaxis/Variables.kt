package com.ljusticia.androidtutorial

fun main(){
    println("hola")
    variablesNumericas()
    showMyAge(29)
    var c = sum(3,2)
    println(c)
    c = sumCool(3,2)
    println(c)
    showDefault()
}

fun variablesNumericas(){
    /**
     * Variables Numéricas
     */
    var age = 30
    var amount:Float = 30.3f
    var amount2:Double = 30.33
    println(age.toFloat() + amount + amount2.toFloat())
}

fun showMyAge(currentAge:Int){
    println("Tienes $currentAge años")
}

fun sum(a:Int, b:Int):Int{
    return(a+b)
}

//Si das valor al parámetro se toma como valor por defecto
fun showDefault(currentValue:Int = 50){
    println("El valor es $currentValue")
}

fun sumCool(a:Int, b:Int) = a+b