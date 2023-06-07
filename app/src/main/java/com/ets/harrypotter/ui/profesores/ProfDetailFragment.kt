package com.ets.harrypotter.ui.profesores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.marginTop
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.ets.harrypotter.R
import com.ets.harrypotter.databinding.FragmentProfDetailBinding
import com.ets.harrypotter.presentation.MainViewModel


class ProfDetailFragment : Fragment(R.layout.fragment_prof_detail) {

    private val mainViewModel:MainViewModel by activityViewModels()
    private lateinit var binding:FragmentProfDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfDetailBinding.bind(view)

        binding.tvNombreResult.text = mainViewModel.profesor.value?.name.toString()


        

        if(mainViewModel.profesor.value!!.image == ""){
            binding.ivImageResult.setImageResource(R.drawable.ic_profesores_minerva)
        }else{
            Glide.with(requireContext()).load(mainViewModel.profesor.value?.image)
                .into(binding.ivImageResult)
        }

        if(mainViewModel.profesor.value!!.wand!!.core == ""){
            binding.tvWand.text = "Desconocido"
        }else{
            binding.tvWand.text = mainViewModel.profesor.value?.wand?.core
        }

        if(mainViewModel.profesor.value!!.species == ""){
            binding.tvEspecie.text = "Desconocido"
        }else{
            binding.tvEspecie.text = mainViewModel.profesor.value?.species.toString()
        }

        if(mainViewModel.profesor.value!!.gender == ""){
            binding.tvGenero.text = "Desconocido"
        }else{
            binding.tvGenero.text = mainViewModel.profesor.value?.gender
        }

        if(mainViewModel.profesor.value!!.house == ""){
            binding.tvCasa.text = "Desconocido"
        }else{
            binding.tvCasa.text = mainViewModel.profesor.value?.house
        }

        if(mainViewModel.profesor.value!!.dateOfBirth == null){
            binding.tvNacimiento.text = "Desconocido"
        }else{
            binding.tvNacimiento.text = mainViewModel.profesor.value?.dateOfBirth
        }

        if(mainViewModel.profesor.value!!.patronus == ""){
            binding.tvPatronus.text = "Desconocido"
        }else{
            binding.tvPatronus.text = mainViewModel.profesor.value?.patronus
        }


    }

}