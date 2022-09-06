package com.example.navcomp

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navcomp.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.util.*


class HomeFragment : Fragment() {

    private val args by navArgs<HomeFragmentArgs>()
    private lateinit var binding : FragmentHomeBinding
    private lateinit var username : String
    private var resultDate : Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDataLogin()
        toProfile()
        doCalculateAge()
    }

    private fun getDataLogin(){
        username = args.username
        val result = username.split(" ")
        // dapetin dan tampilin kata pertama dari username
        val username = "Hallo ${result[0]}"
        binding.tvResult.text = username
    }

    private fun toProfile(){
        binding.btnProfile.setOnClickListener {
            val args = HomeFragmentDirections.actionHomeFragmentToProfileFragment(username)
            findNavController().navigate(args)
        }
    }

    private fun doCalculateAge(){
        val now = Calendar.getInstance()
        val year = now.get(Calendar.YEAR)
        val month = now.get(Calendar.MONTH)
        val day = now.get(Calendar.DAY_OF_MONTH)
        binding.etAge.setOnClickListener {
            val datePicker = DatePickerDialog(requireActivity(),DatePickerDialog.OnDateSetListener{ _, myear, _, _ ->
                resultDate = myear
                if(resultDate <= now.get(Calendar.YEAR)){
                    binding.etAge.setText(resultDate.toString())
                }else{
                    Toast.makeText(activity, "Invalid Year, did you come from the future?", Toast.LENGTH_SHORT).show()
                }
            },year,month,day
            )
            datePicker.show()
        }

        binding.btnCalculate.setOnClickListener {

            val age = binding.etAge.text.toString()
            val resultAge = now.get(Calendar.YEAR) - age.toInt()
            val args = HomeFragmentDirections.actionHomeFragmentToAgeFragment(username,resultAge)
            if(age.isNotBlank()){
                findNavController().navigate(args)
            }else{
                Toast.makeText(activity, "Please fill your age", Toast.LENGTH_SHORT).show()
            }
        }

    }


}