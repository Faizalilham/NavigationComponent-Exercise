package com.example.navcomp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.navcomp.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {


    private lateinit var binding : FragmentProfileBinding
    private val args by navArgs<ProfileFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataFromHome()
        logout()
    }

    private fun getDataFromHome(){
        binding.tvProfileResult.text = args.fullUsername
    }

    private fun logout(){
        binding.btnLogout.setOnClickListener { activity?.finish() }
    }


}