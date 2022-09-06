package com.example.navcomp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.navcomp.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {


    private lateinit var binding : FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toRegister()
        toForgetPassword()
        toHelp()
        toChat()
        toLogin()
    }

    private fun toRegister(){
        binding.tvRegister.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.registerFragment)
        }
    }

    private fun toForgetPassword(){
        binding.tvForgetPassword.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.forgetPasswordFragment)
        }
    }
    private fun toHelp(){
        binding.fabHelp.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.helpFragment)
        }
    }

    private fun toChat(){
        binding.fabChat.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.contactFragment)
        }
    }

     private fun toLogin(){
         binding.btnLogin.setOnClickListener {
             val username = binding.etUsername.text.toString()
             val password = binding.etPassword.text.toString()
             val args = LoginFragmentDirections.actionLoginFragmentToHomeFragment(username,password)
             if(username.isNotBlank() && password.isNotBlank()){
               if(username == RegisterFragment.USERNAME && password == RegisterFragment.PASSWORD){
                    findNavController().navigate(args)
                    Toast.makeText(activity, "Welcome $username", Toast.LENGTH_SHORT).show()
               }else{
                   Toast.makeText(activity, "Wrong username or password", Toast.LENGTH_SHORT).show()
               }
             }else{
                 Toast.makeText(activity, "Please fill username and password", Toast.LENGTH_SHORT).show()
             }
         }
     }



}