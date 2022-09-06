package com.example.navcomp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.navcomp.databinding.FragmentAgeBinding


class AgeFragment : Fragment() {

    private lateinit var  binding : FragmentAgeBinding
    private val args by navArgs<AgeFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataFromHome()
    }

    private fun getDataFromHome(){
        val name = "Hallo ${args.username}"
        binding.tvName.text = name
        val age = """
            Umur Kamu
               ${args.age} Tahun
        """.trimIndent()

        binding.tvAge.text = age
    }


}