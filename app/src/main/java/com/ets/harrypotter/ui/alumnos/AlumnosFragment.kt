package com.ets.harrypotter.ui.alumnos

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ets.harrypotter.R
import com.ets.harrypotter.core.Results
import com.ets.harrypotter.data.remote.HpDataSource
import com.ets.harrypotter.databinding.FragmentAlumnosBinding
import com.ets.harrypotter.presentation.HPViewModelFactory
import com.ets.harrypotter.presentation.HpViewModel
import com.ets.harrypotter.repository.HpRepositoryImp
import com.ets.harrypotter.repository.RetrofitClient

class AlumnosFragment : Fragment(R.layout.fragment_alumnos) {

    private lateinit var binding: FragmentAlumnosBinding
    private val hpViewMoodel:HpViewModel by viewModels<HpViewModel>{
        HPViewModelFactory(HpRepositoryImp(HpDataSource(RetrofitClient.webService)))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlumnosBinding.bind(view)

        hpViewMoodel.fetchAlumnos().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Results.Loading -> Log.d("LiveData", "Loading ...")

                is Results.Success -> Log.d("LiveData","${result.data.toString()}")

                is Results.Failure -> Log.d("Live Data", "${result.exception}")
            }

        })
    }

}