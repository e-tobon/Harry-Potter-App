package com.ets.harrypotter.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ets.harrypotter.R
import com.ets.harrypotter.databinding.FragmentRegistroBinding


class RegistroFragment : Fragment(R.layout.fragment_registro) {

    lateinit var binding:FragmentRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegistroBinding.bind(view)
    }

}