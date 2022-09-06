package com.example.navcomp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.navcomp.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar


class RegisterFragment : Fragment() {


    companion object{
        var USERNAME = "Faizalilham"
        var NAME = "Faizal"
        var PASSWORD = "12345678"
    }
    
    private lateinit var binding : FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        doRegister()
    }
    
    private fun doRegister(){
        binding.btnRegister.setOnClickListener { 
            val username = binding.etUsername.text.toString()
            val name = binding.etName.text.toString()
            val password = binding.etPassword.text.toString()
            if(username.isNotBlank() && name.isNotBlank() && password.isNotBlank()){
                if(password.length >= 8){
                    USERNAME = username
                    NAME = name
                    PASSWORD = password
                    Navigation.findNavController(binding.root).navigate(R.id.loginFragment)
                }else{
                    Toast.makeText(activity, "Password must be at least eight digits lettera", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(activity, "Please fill in all data", Toast.LENGTH_SHORT).show()
            }
        }
    }


}