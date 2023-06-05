package com.ets.harrypotter.ui.alumnos

import android.graphics.Path.Direction
import android.os.Bundle
import android.telephony.mbms.DownloadRequest
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.ets.harrypotter.R
import com.ets.harrypotter.core.Results
import com.ets.harrypotter.data.remote.HpDataSource
import com.ets.harrypotter.databinding.FragmentAlumnosBinding
import com.ets.harrypotter.presentation.HPViewModelFactory
import com.ets.harrypotter.presentation.HpViewModel
import com.ets.harrypotter.presentation.MainViewModel
import com.ets.harrypotter.repository.HpRepositoryImp
import com.ets.harrypotter.repository.RetrofitClient

class AlumnosFragment : Fragment(R.layout.fragment_alumnos) {


    private val mainViewModel: MainViewModel by activityViewModels()
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
                is Results.Loading -> {
                    binding.pogressBar.isVisible = true
                    Log.d("LiveData", "Loading ...")
                }
                is Results.Success ->{
                    binding.pogressBar.isVisible = false
                    Log.d("LiveData","${result.data.toString()}")
                    binding.rvAlumnos.layoutManager = GridLayoutManager(requireContext(),3)
                    binding.rvAlumnos.adapter = AlumnoAdapter(requireContext(),result.data){
                        mainViewModel.setAlumnos(it)
                        findNavController().navigate(R.id.action_alumnosFragment_to_alumnoDetailFragment)
                    }

                }

                is Results.Failure -> {
                    binding.pogressBar.isVisible = false
                    Log.d("Live Data", "${result.exception}")
                    Toast.makeText(requireContext(),getString(R.string.problem_internet),Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

}