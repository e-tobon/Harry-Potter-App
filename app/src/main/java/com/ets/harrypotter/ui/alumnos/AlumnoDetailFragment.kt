package com.ets.harrypotter.ui.alumnos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.ets.harrypotter.R
import com.ets.harrypotter.databinding.FragmentAlumnoDetailBinding
import com.ets.harrypotter.presentation.MainViewModel


class AlumnoDetailFragment : Fragment(R.layout.fragment_alumno_detail) {
    private val mainViewModel:MainViewModel by activityViewModels()
    private lateinit var binding: FragmentAlumnoDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlumnoDetailBinding.bind(view)
        binding.tvNombreResult.text = mainViewModel.alumnos.value?.name
        binding.tvEspecie.text = mainViewModel.alumnos.value?.species
        binding.tvGenero.text = mainViewModel.alumnos.value?.gender
        binding.tvCasa.text = mainViewModel.alumnos.value?.house
        binding.tvNacimiento.text = mainViewModel.alumnos.value?.dateOfBirth
        Glide.with(requireContext()).load(mainViewModel.alumnos.value?.image)
            .into(binding.ivImageResult)
        binding.tvWand.text = mainViewModel.alumnos.value?.wand?.core
        binding.tvPatronus.text = mainViewModel.alumnos.value?.patronus

        if(mainViewModel.alumnos.value!!.alternate_names!!.isNotEmpty()){
            binding.tvNombreAlias.text = mainViewModel.alumnos.value?.alternate_names!![0]
        }

    }
}