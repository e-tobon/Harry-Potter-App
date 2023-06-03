package com.ets.harrypotter.ui.profesores

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.ets.harrypotter.R
import com.ets.harrypotter.core.Results
import com.ets.harrypotter.data.remote.HpDataSource
import com.ets.harrypotter.databinding.FragmentProfesoresBinding
import com.ets.harrypotter.presentation.HPViewModelFactory
import com.ets.harrypotter.presentation.HpViewModel
import com.ets.harrypotter.repository.HpRepositoryImp
import com.ets.harrypotter.repository.RetrofitClient


class ProfesoresFragment : Fragment(R.layout.fragment_profesores) {

    private lateinit var binding: FragmentProfesoresBinding

    private val hpViewModel:HpViewModel by viewModels<HpViewModel> {
        HPViewModelFactory(HpRepositoryImp(HpDataSource(RetrofitClient.webService)))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfesoresBinding.bind(view)

        hpViewModel.fetchProfesores().observe(viewLifecycleOwner, Observer { result ->
            when(result){
                is Results.Loading -> Log.d("LiveDataP","Loading...")
                is Results.Success -> {
                    binding.rvProfesores.layoutManager = GridLayoutManager(requireContext(),3)
                    binding.rvProfesores.adapter = ProfesresAdapter(requireContext(),result.data)
                }
                is Results.Failure -> {
                    Log.d("LiveDataP","${result.exception}")
                }
            }
        })

    }


}