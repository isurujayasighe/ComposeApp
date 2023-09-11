package com.example.composeapp.flow

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main (){
    println("******")
    runBlocking {
        val values = getValuesSequence()
        for (value in values){
            println("*${value}*")
        }
    }
}

private suspend fun getValues():List<Int> {
    delay(1000L)
    return listOf(1,2,3,4,5,6,7,8,9)
}

private suspend fun getValuesSequence(): Sequence<Int> = sequence {
    Thread.sleep(250)
    yield(1)
    Thread.sleep(250)
    yield(2)
    Thread.sleep(1000)
    yield(3)
}
