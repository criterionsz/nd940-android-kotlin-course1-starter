package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentInformationBinding

class InformationFragment : Fragment() {
    lateinit var binding: FragmentInformationBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_information,
            container,
            false
        )
        binding.continueButton.setOnClickListener {
            findNavController().navigate(R.id.action_informationFragment_to_listShoesFragment)
        }
        return binding.root
    }
}