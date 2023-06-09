package com.ets.harrypotter.ui.login

import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ets.harrypotter.R
import com.ets.harrypotter.databinding.FragmentRegistroBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RegistroFragment : Fragment(R.layout.fragment_registro) {

    private lateinit var auth: FirebaseAuth
    lateinit var binding:FragmentRegistroBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRegistroBinding.bind(view)




        binding.btnRegistro.setOnClickListener{

            val email = binding.etEmailRegister.text.toString()
            val password = binding.etPasswordRegister.text.toString()
            val userName = binding.etUserName.text.toString()

            if (!email.isEmpty() and  !password.isEmpty() ){

                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    Toast.makeText(requireContext(),getString(R.string.formatEmail),Toast.LENGTH_LONG).show()
                }
                if(password.length<6){
                    Toast.makeText(requireContext(),getString(R.string.passwordLengh),Toast.LENGTH_LONG).show()
                }
                if(Patterns.EMAIL_ADDRESS.matcher(email).matches() and (password.length > 5)){
                    registroUsuario(userName,email,password)
                }


            }
            else if(email.isEmpty() or password.isEmpty() or userName.isEmpty()){
                Toast.makeText(requireContext(),getString(R.string.camposVacios),Toast.LENGTH_LONG).show()
            }

        }

    }


    private fun registroUsuario(userName:String,email:String,password:String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {

                    Toast.makeText(
                        requireContext(),
                        "El usario $userName creado con exito!", Toast.LENGTH_SHORT
                    ).show()
                    findNavController().navigate(R.id.action_registroFragment_to_loginFragment)

                } else {
                    Toast.makeText(
                        requireContext(),
                        getString(R.string.errorRegistro),
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

    }

}