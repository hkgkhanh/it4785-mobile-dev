package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val handler = CoroutineExceptionHandler { _, exception ->
            println("Error here: ${exception.toString()}")
        }
        val job = GlobalScope.launch(handler) {
            println("Throw Exception from Launch")
            throw NullPointerException()
        }
        // chờ đợi coroutine hoàn thành
        job.join()
        val deferred = GlobalScope.async {
            println("Throw Exception from Async")
            throw IndexOutOfBoundsException()
        }
        try {
            deferred.await()
        } catch (e: IndexOutOfBoundsException) {
            println(e.toString())
        }
    }
}