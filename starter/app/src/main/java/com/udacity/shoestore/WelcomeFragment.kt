package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {
    lateinit var binding: FragmentWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome,
            container,
            false
        )
        binding.continueButton.setOnClickListener {
            findNavController().navigate(R.id.action_welcomeFragment_to_informationFragment)
        }
        return binding.root
    }
}