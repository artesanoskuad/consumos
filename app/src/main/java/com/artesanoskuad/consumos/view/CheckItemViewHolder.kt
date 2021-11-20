package com.artesanoskuad.consumos.view

import androidx.recyclerview.widget.RecyclerView
import com.artesanoskuad.consumos.databinding.ItemCheckRegisterBinding
import com.artesanoskuad.consumos.model.Items

class CheckItemViewHolder(
    private val binding: ItemCheckRegisterBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(items: Items){
        with(binding){
            tvItemName.text = items.name
            tvItemAmount.text = items.amount.toString()
            tvItemTotal.text = items.total.toString()
        }
    }

}