package com.ets.harrypotter.ui.alumnos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
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
        Toast.makeText(requireContext(),"${mainViewModel.alumnos.value}",Toast.LENGTH_LONG).show()
    }
}