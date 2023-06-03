package com.ets.harrypotter.repository

import com.ets.harrypotter.data.model.HpAlumno
import com.ets.harrypotter.data.model.HpProfesor
import com.ets.harrypotter.data.remote.HpDataSource

class HpRepositoryImp(private val dataSource: HpDataSource):HpRepository {

    override suspend fun getAlumnos(): List<HpAlumno> = dataSource.getAlumnos()

    override suspend fun getProfesores(): List<HpProfesor> = dataSource.getProfesores()
}