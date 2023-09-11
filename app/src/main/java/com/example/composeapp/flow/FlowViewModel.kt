package com.example.composeapp.flow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class FlowViewModel : ViewModel() {

    val countDownFlow = flow {
        val startingValue = 10
        var currentValue = startingValue
        emit(currentValue)
        while (currentValue > 0) {
            delay(1000L)
            currentValue--
            emit(currentValue)
        }
    }

    init {
        collectFlow()
        GlobalScope.launch {

        }

        runBlocking {

        }

        GlobalScope.async {

        }
    }

    private fun collectFlow(){
        viewModelScope.launch {
            countDownFlow.collect{ time ->
                print("the Current Time is $time")
            }
        }
    }
}