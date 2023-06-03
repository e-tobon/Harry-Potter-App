package com.ets.harrypotter.repository

import com.ets.harrypotter.data.model.AlumnoList
import com.ets.harrypotter.data.model.HpAlumno
import com.ets.harrypotter.data.model.HpProfesor
import com.ets.harrypotter.data.model.ProfesoresList
import com.ets.harrypotter.utils.AppConstants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface WebService {
    @GET("students")
    suspend fun getAlumnos(): List<HpAlumno>
    @GET("staff")
    suspend fun getProfesores(): List<HpProfesor>
}

object RetrofitClient{
    val webService by lazy {
        Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(WebService::class.java)
    }
}

