package com.artesanoskuad.consumos

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import com.artesanoskuad.consumos.databinding.FragmentCheckRegisterDetailsBinding
import com.artesanoskuad.utils.CurrencyUtils
import java.lang.NumberFormatException

class CheckRegisterDetailsFragment : Fragment() {

    private var _binding: FragmentCheckRegisterDetailsBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCheckRegisterDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupNumberPicker()
        setupEditTextPrice()
        binding.btnGuardar.setOnClickListener {
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    private fun setupEditTextPrice() {
        binding.etItemPrice.doAfterTextChanged {
            val countItems = binding.npItemAmount.value
            showNewTotalValue(getPrice(), countItems)
        }
    }

    private fun setupNumberPicker() {
        with(binding.npItemAmount){
            minValue = 0
            maxValue = 100
            wrapSelectorWheel = true
            setOnValueChangedListener { _, _, newVal ->
                showNewTotalValue(getPrice(), newVal)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showNewTotalValue(price: Int, newVal: Int) {
        val newTotal = newVal * price
        binding.tvTotal.text = CurrencyUtils.currencyFormat(newTotal)
    }

    private fun getPrice(): Int {
        return try {
            binding.etItemPrice.text.toString().toInt()
        } catch (exception: NumberFormatException) {
            0
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}