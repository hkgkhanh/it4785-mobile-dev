package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val handler = CoroutineExceptionHandler { _, exception ->
            println("Error here: ${exception.toString()}")
        }
        val job = GlobalScope.launch(handler + Dispatchers.Default) {
            println("Throw Exception from Launch")
            throw NullPointerException()
        }
        // chờ đợi coroutine hoàn thành
        job.join()
        val deferred = GlobalScope.async(handler) {
            println("Throw Exception from Async")
            throw IndexOutOfBoundsException()
        }
        deferred.await()
    }
}