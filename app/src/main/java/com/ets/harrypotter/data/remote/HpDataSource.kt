package com.ets.harrypotter.data.remote

import com.ets.harrypotter.data.model.HpAlumno
import com.ets.harrypotter.data.model.HpProfesor
import com.ets.harrypotter.repository.WebService

class HpDataSource(private val webService: WebService) {
    suspend fun getAlumnos():List<HpAlumno> = webService.getAlumnos()

    suspend fun getProfesores():List<HpProfesor> = webService.getProfesores()
}