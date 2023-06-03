package com.ets.harrypotter.ui.profesores

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ets.harrypotter.R
import com.ets.harrypotter.databinding.FragmentProfesoresBinding

class ProfesoresDetailFragment : Fragment(R.layout.fragment_profesores_detail) {

    private lateinit var binding: FragmentProfesoresBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProfesoresBinding.bind(view)
    }
}