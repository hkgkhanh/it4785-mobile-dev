package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job = GlobalScope.launch {
            try {
                println("Throw Exception from Launch")
                throw NullPointerException()
            } catch (e: NullPointerException) {
                println(e.toString())
            }
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