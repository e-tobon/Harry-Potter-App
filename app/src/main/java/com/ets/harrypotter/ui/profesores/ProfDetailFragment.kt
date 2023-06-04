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
        binding.tvEspecie.text = mainViewModel.profesor.value?.species.toString()
        binding.tvNombreResult.text = mainViewModel.profesor.value?.name.toString()
        Glide.with(requireContext()).load(mainViewModel.profesor.value?.image)
            .into(binding.ivImageResult)


    }

}