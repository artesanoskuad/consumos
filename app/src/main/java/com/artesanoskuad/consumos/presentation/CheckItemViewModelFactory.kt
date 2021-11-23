package com.artesanoskuad.consumos.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.artesanoskuad.consumos.model.ConsumosDatabase

class CheckItemViewModelFactory(val consumosDatabase: ConsumosDatabase) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(ConsumosDatabase::class.java)
            .newInstance(consumosDatabase)
    }

}
