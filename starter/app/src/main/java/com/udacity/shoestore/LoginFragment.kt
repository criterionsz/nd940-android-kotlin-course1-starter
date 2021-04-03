package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )
        setListener(binding.login)
        setListener(binding.signup)

        return binding.root
    }
    private fun isEmptyFields(): Boolean =
        (binding.editTextTextEmailAddress.text.toString().isEmpty() ||
                binding.editTextTextPassword.text.toString().isEmpty())


    private fun setListener(view: View) {
        view.setOnClickListener {
            if (isEmptyFields()) {
                Toast.makeText(requireContext(), "Fill all fields", Toast.LENGTH_LONG).show()
            } else {
                findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)
            }
        }
    }
}