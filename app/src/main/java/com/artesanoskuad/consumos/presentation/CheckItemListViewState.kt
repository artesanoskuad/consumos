package com.artesanoskuad.consumos.presentation

import com.artesanoskuad.consumos.model.Items

sealed class CheckItemListViewState{
    object LoadingViewState : CheckItemListViewState()
    data class ShowCheckItemListViewState(val list: List<Items>) : CheckItemListViewState()
    object ShowEmptyListViewState : CheckItemListViewState()
    object ShowServerErrorViewState : CheckItemListViewState()
}
