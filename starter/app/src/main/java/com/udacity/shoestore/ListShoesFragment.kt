package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentListShoesBinding
import com.udacity.shoestore.databinding.FragmentShoeDescriptionBinding
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.fragment_shoe_description.view.*

class ListShoesFragment : Fragment() {
    lateinit var binding: FragmentListShoesBinding
    private val vm: MainViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list_shoes,
            container,
            false
        )

        binding.floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.action_listShoesFragment_to_detailShoeFragment)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.shoes.observe(viewLifecycleOwner) { shoes ->
            for (shoe in shoes) {
                bind(shoe)
            }
        }
    }

    private fun bind(shoe: Shoe) {
        val bindingShoe = DataBindingUtil.inflate<FragmentShoeDescriptionBinding>(
            layoutInflater,
            R.layout.fragment_shoe_description,
            binding.shoesList,
            false
        ).root
        bindingShoe.apply {
            name.text = shoe.name
            size.text = shoe.size.toString()
            company.text = shoe.company
            description.text = shoe.description
        }
        binding.shoesList.addView(bindingShoe)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController()) ||
                super.onOptionsItemSelected(item)
    }
}