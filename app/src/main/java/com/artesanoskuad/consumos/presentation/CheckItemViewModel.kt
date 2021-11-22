package com.artesanoskuad.consumos.presentation

import androidx.lifecycle.*
import com.artesanoskuad.consumos.model.ConsumosDatabase
import com.artesanoskuad.consumos.model.Items
import com.artesanoskuad.consumos.presentation.CheckItemListViewState.*
import kotlinx.coroutines.launch

class CheckItemViewModel(
    private val consumosDatabase: ConsumosDatabase
) : ViewModel() {

    private val mutableState = MutableLiveData<CheckItemListViewState>()

    fun state(): LiveData<CheckItemListViewState> = mutableState

    fun initViewModel() {
        mutableState.postValue(LoadingViewState)
        viewModelScope.launch {
            try {
                val responseItems = consumosDatabase.itemsDao().getAll()
                handleResponse(responseItems)
            } catch(e: Exception){
                mutableState.postValue(ShowServerErrorViewState)
            }
        }
    }

    private fun handleResponse(responseItems: List<Items>) {
        if(responseItems.isEmpty()){
            mutableState.postValue(ShowEmptyListViewState)
        } else {
            mutableState.postValue(ShowCheckItemListViewState(responseItems))
        }
    }

}