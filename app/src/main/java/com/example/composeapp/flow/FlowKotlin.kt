package com.example.composeapp.flow

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


//fun main (){
//    val thread = Thread {
//        println("${Thread.currentThread()} has run.")
//    }
//
//    thread.start()
//}


//fun main () = runBlocking{
//    launch {
//    delay(1000L)
//        println("World!")
//    }
//    println("Hello")
//}


fun main () = runBlocking {
    val resultDeferred: Deferred<Int> = async {
        delay(4000L)
        86
    }
    val result: Int = resultDeferred.await()
    println(result)
}