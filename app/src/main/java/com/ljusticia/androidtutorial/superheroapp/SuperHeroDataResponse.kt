package com.ljusticia.androidtutorial.superheroapp

import com.google.gson.annotations.SerializedName

//el nombre del parámetro tiene que ser igual al nombre del valor en el JSON
//para poder llamarle diferente se usa SerializedName
data class SuperHeroDataResponse (@SerializedName("response") val response:String)