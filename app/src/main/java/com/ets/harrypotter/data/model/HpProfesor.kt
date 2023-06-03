package com.ets.harrypotter.data.model

data class HpProfesor(
    val id: Int?,
    val name: String?,
    val actor: String?,
    val image: String?

)

data class ProfesoresList(
    val result: List<HpProfesor> = listOf()
)