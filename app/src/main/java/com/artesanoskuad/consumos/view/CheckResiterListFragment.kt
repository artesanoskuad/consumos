package com.artesanoskuad.consumos.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.artesanoskuad.consumos.R
import com.artesanoskuad.consumos.databinding.FragmentCheckRegisterListBinding
import com.artesanoskuad.consumos.model.Items

class CheckResiterListFragment : Fragment() {

    private var _binding: FragmentCheckRegisterListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCheckRegisterListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun setupRecyclerView() {
        context?.let { notNullContext ->
            val adapter = CheckItemAdapter(fakesValues())
            val layoutManager = LinearLayoutManager(notNullContext)
            with(binding){
                rvListCheckRegister.adapter = adapter
                rvListCheckRegister.layoutManager = layoutManager
            }
        }
    }

    fun fakesValues() : List<Items> {
        val list = ArrayList<Items>()
        for(indice in 1..100){
            list.add(createFakeItem(indice))
        }
        return  list
    }

    private fun createFakeItem(indice: Int): Items {
        return Items(indice, "name : $indice", indice, indice)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}