package com.ets.harrypotter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ets.harrypotter.data.model.HpAlumno
import com.ets.harrypotter.data.model.HpProfesor

class MainViewModel: ViewModel() {

    private var _alumnos = MutableLiveData<HpAlumno>()
    val alumnos:LiveData<HpAlumno>
    get() = _alumnos

    private var _profesor = MutableLiveData<HpProfesor>()
    val profesor:LiveData<HpProfesor>
    get() = _profesor

    fun setAlumnos(alumno: HpAlumno){
        _alumnos.value = alumno
    }

    fun setProfesores(profesor: HpProfesor){
        _profesor.value = profesor
    }
}