package com.ets.harrypotter.repository

import com.ets.harrypotter.data.model.HpAlumno
import com.ets.harrypotter.data.model.HpProfesor

interface HpRepository {
    suspend fun getAlumnos():List<HpAlumno>
    suspend fun getProfesores():List<HpProfesor>
}