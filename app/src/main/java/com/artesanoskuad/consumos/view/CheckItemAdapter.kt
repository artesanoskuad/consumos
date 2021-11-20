package com.artesanoskuad.consumos.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artesanoskuad.consumos.databinding.ItemCheckRegisterBinding
import com.artesanoskuad.consumos.model.Items

class CheckItemAdapter(
    private var itemsList: List<Items>
) : RecyclerView.Adapter<CheckItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckItemViewHolder {
        val binding: ItemCheckRegisterBinding = ItemCheckRegisterBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CheckItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CheckItemViewHolder, position: Int) {
        holder.bind(itemsList[position])
    }

    override fun getItemCount(): Int {
        return itemsList.size
    }
}