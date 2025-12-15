package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job = GlobalScope.launch {
            println("Throw Exception from Launch")
            throw NullPointerException()
        }
        // chờ đợi coroutine hoàn thành
        job.join()
        val deferred = GlobalScope.async {
            println("Throw Exception from Async")
            throw IndexOutOfBoundsException()
        }
    }
}