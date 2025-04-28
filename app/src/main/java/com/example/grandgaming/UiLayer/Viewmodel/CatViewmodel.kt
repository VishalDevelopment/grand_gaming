package com.example.grandgaming.UiLayer.Viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

import com.example.grandgaming.Common.State.State
import com.example.grandgaming.DataLayer.Model.Cat
import com.example.grandgaming.DataLayer.Repo.CatRepository
import kotlinx.coroutines.launch

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class CatViewModel @Inject constructor(
    private val repository: CatRepository
) : ViewModel() {

    private val _catsState = MutableStateFlow<State<List<Cat>>>(State.Loading())
    val catsState: StateFlow<State<List<Cat>>> = _catsState

    fun fetchCats() {
        viewModelScope.launch {
            _catsState.value = State.Loading()
            val result = repository.getCatList()
            _catsState.value = result
        }
    }
}
