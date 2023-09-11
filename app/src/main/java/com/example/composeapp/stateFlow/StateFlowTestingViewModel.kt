package com.example.composeapp.stateFlow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StateFlowTestingViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(0)
    private val _dataFlow = MutableStateFlow<List<String>>(emptyList())
    val uiState: StateFlow<Int> = _uiState
    val dataFlow: StateFlow<List<String>> = _dataFlow

    fun increment (){
        _uiState.value++
    }

    init {
        loadData()
        Person(
            fName = "Isuru",
            lName = "Jayasinghe",
            city = "Nawala"
        ).let {

        }

        Person(
            fName = "Isuru",
            lName = "Jayasinghe",
            city = "Nawala"
        ).apply {
            
        }
    }


    private fun loadData (){
        viewModelScope.launch {
            delay(5000L)
            _dataFlow.emit(listOf("item 1","Item 2","Item 3","Item 4"))
        }
    }

}