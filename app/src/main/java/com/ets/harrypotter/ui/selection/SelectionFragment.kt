package com.ets.harrypotter.ui.selection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ets.harrypotter.R
import com.ets.harrypotter.databinding.FragmentSelectionBinding


class SelectionFragment : Fragment(R.layout.fragment_selection) {

    lateinit var binding: FragmentSelectionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSelectionBinding.bind(view)

        binding.ivAlumnos.setOnClickListener{
            findNavController().navigate(R.id.action_selectionFragment_to_alumnosFragment)
        }

        binding.ivProfesores.setOnClickListener{
            findNavController().navigate(R.id.action_selectionFragment_to_profesoresFragment)
        }
    }
}