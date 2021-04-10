package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentDetailShoeBinding
import com.udacity.shoestore.models.Shoe

class DetailShoeFragment : Fragment() {
    private lateinit var binding: FragmentDetailShoeBinding
    private val vm: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_shoe, container, false)
        binding.shoe = Shoe("", 0.0, "", "")
        binding.cancel.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.save.setOnClickListener {
            if (isEmptyField(binding.editCompany) || isEmptyField(binding.editDescription)
                || isEmptyField(binding.editName) || isEmptyField(binding.editShoeSize)
            ) {
                Toast.makeText(requireContext(), "Fill all fields", Toast.LENGTH_LONG).show()
            } else {
                binding.company
                binding.shoe?.let {
                    vm.updateShoes(
                        it
                    )
                }

                findNavController().popBackStack()
            }
        }

        return binding.root
    }

    private fun isEmptyField(editText: EditText) =
        editText.text.isNullOrBlank()


}