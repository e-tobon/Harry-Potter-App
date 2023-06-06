package com.ets.harrypotter.ui.login

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ets.harrypotter.R
import com.ets.harrypotter.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var auth: FirebaseAuth

    lateinit var binding: FragmentLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLoginBinding.bind(view)
        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()

            if(email.isEmpty()){
                Toast.makeText(requireContext(), getString(R.string.sessionstart), Toast.LENGTH_SHORT).show()
            }


            if(!email.isEmpty() and !password.isEmpty()){
                loginEmai(email,password)
            }



        }
        binding.tvCrearCuenta.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registroFragment)
        }
    }

    private fun loginEmai( email:String, password:String){

            auth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        findNavController().navigate(R.id.action_loginFragment_to_selectionFragment)
                    }else{
                        Toast.makeText(requireContext(),getString(R.string.problema),Toast.LENGTH_LONG).show()
                    }
                }
    }
}