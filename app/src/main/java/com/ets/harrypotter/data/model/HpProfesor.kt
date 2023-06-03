package com.ets.harrypotter.data.model

data class HpProfesor(
    val id: String?,
    val name: String?,
    val actor: String?,
    val image: String?,
    val species: String?,
    val gender: String?,
    val house: String?,
    val dateOfBirth: String?,
    val yearOfBirth:String?,
    val wand:WandProfesor?,
    val patronus:String


)

data class WandProfesor(
    val wood: String?,
    val core: String?,
    val length: String?

)