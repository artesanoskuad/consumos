package com.artesanoskuad.consumos.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.artesanoskuad.consumos.R
import com.artesanoskuad.consumos.databinding.FragmentCheckRegisterListBinding

class CheckRegiterListFragment : Fragment() {

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
            val adapter = CheckItemAdapter(emptyList())
            val layoutManager = LinearLayoutManager(notNullContext)
            with(binding){
                rvListCheckRegister.adapter = adapter
                rvListCheckRegister.layoutManager = layoutManager
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}