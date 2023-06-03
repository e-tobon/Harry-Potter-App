package com.ets.harrypotter.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.ets.harrypotter.core.Results
import com.ets.harrypotter.repository.HpRepository
import kotlinx.coroutines.Dispatchers

class HpViewModel(private val repo:HpRepository):ViewModel() {

    fun fetchAlumnos() =
        liveData(Dispatchers.IO) {
            emit(Results.Loading())
            try {
                emit(Results.Success(repo.getAlumnos()))
            } catch (e: Exception) {
                emit(Results.Failure(e))
            }
        }

}

class HPViewModelFactory(private val repo: HpRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(HpRepository::class.java).newInstance(repo)
    }
}