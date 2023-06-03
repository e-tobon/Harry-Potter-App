package com.ets.harrypotter.ui.alumnos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ets.harrypotter.R
import com.ets.harrypotter.databinding.FragmentAlumnoDetailBinding


class AlumnoDetailFragment : Fragment(R.layout.fragment_alumno_detail) {
    private lateinit var binding: FragmentAlumnoDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlumnoDetailBinding.bind(view)
    }
}