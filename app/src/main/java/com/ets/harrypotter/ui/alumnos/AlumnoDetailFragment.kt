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

        if(mainViewModel.alumnos.value!!.alternate_names!!.isNotEmpty()){
            binding.tvNombreAlias.text = mainViewModel.alumnos.value?.alternate_names!![0]
        }

        if(mainViewModel.alumnos.value!!.image == ""){
                binding.ivImageResult.setImageResource(R.drawable.ic_alumno)
            }else{
            Glide.with(requireContext()).load(mainViewModel.alumnos.value?.image)
                .into(binding.ivImageResult)
        }

        if(mainViewModel.alumnos.value!!.wand!!.core == ""){
            binding.tvWand.text = "Desconocido"
        }else{
            binding.tvWand.text = mainViewModel.alumnos.value?.wand?.core
        }

        if(mainViewModel.alumnos.value!!.species == ""){
            binding.tvEspecie.text = "Desconocido"
        }else{
            binding.tvEspecie.text = mainViewModel.alumnos.value?.species
        }

        if(mainViewModel.alumnos.value!!.gender == ""){
            binding.tvGenero.text = "Desconocido"
        }else{
            binding.tvGenero.text = mainViewModel.alumnos.value?.gender
        }

        if(mainViewModel.alumnos.value!!.house == ""){
            binding.tvCasa.text = "Desconocido"
        }else{
            binding.tvCasa.text = mainViewModel.alumnos.value?.house
        }

        if(mainViewModel.alumnos.value!!.dateOfBirth == null){
            binding.tvNacimiento.text = "Desconocido"
        }else{
            binding.tvNacimiento.text = mainViewModel.alumnos.value?.dateOfBirth
        }

        if(mainViewModel.alumnos.value!!.patronus == ""){
            binding.tvPatronus.text = "Desconocido"
        }else{
            binding.tvPatronus.text = mainViewModel.alumnos.value?.patronus
        }

    }
}