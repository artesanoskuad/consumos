package com.artesanoskuad.consumos.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.artesanoskuad.consumos.R
import com.artesanoskuad.consumos.databinding.FragmentCheckRegisterListBinding
import com.artesanoskuad.consumos.model.ConsumosDatabase
import com.artesanoskuad.consumos.model.Items
import com.artesanoskuad.consumos.presentation.CheckItemListViewState
import com.artesanoskuad.consumos.presentation.CheckItemListViewState.*
import com.artesanoskuad.consumos.presentation.CheckItemViewModel
import com.artesanoskuad.consumos.presentation.CheckItemViewModelFactory

class CheckRegiterListFragment : Fragment() {

    private var _binding: FragmentCheckRegisterListBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: CheckItemViewModel
    private lateinit var viewModelFactory: CheckItemViewModelFactory
    private lateinit var consumosDatabase: ConsumosDatabase


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
        setupConsumosDatabase()
        setupViewModel()
        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun setupConsumosDatabase() {
        activity?.let { safeContext ->
            consumosDatabase = Room.databaseBuilder(
                safeContext.applicationContext,
                ConsumosDatabase::class.java, "database-consumos"
            ).build()
        }
    }

    private fun setupViewModel() {
        viewModelFactory = CheckItemViewModelFactory(consumosDatabase)
        viewModel = ViewModelProvider(this, viewModelFactory)[CheckItemViewModel::class.java]
        viewModel.initViewModel()
        viewModel.state().observe(viewLifecycleOwner, {
            it?.let { safeCheckItemViewState ->
                handleCheckViewState(safeCheckItemViewState)
            }
        })
    }

    private fun handleCheckViewState(state: CheckItemListViewState) {
        when (state) {
            is LoadingViewState -> showLoading()
            is ShowCheckItemListViewState -> showList(state.list)
            is ShowEmptyListViewState -> showEmptyList()
            is ShowServerErrorViewState -> showServerError()
        }
    }

    private fun showServerError() {
        Toast.makeText(requireContext(), "Server Error", Toast.LENGTH_LONG).show()
    }

    private fun showEmptyList() {
        Toast.makeText(requireContext(), "Empty List", Toast.LENGTH_LONG).show()
    }

    private fun showList(list: List<Items>) {
        Toast.makeText(requireContext(), "List Size: ${list.size}", Toast.LENGTH_LONG).show()

    }

    private fun showLoading() {
        Toast.makeText(requireContext(), "Loading", Toast.LENGTH_LONG).show()
    }

    private fun setupRecyclerView() {
        context?.let { notNullContext ->
            val adapter = CheckItemAdapter(emptyList())
            val layoutManager = LinearLayoutManager(notNullContext)
            with(binding) {
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