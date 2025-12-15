package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val handle = CoroutineExceptionHandler {_, exception ->
            println("Exception: $exception")
        }
        val job = GlobalScope.launch(handle) {
            launch {
                println("Coroutine 1")
                delay(300)
                println("Coroutine 1 continue")
                throw IndexOutOfBoundsException("Coroutine 1")
            }
            launch {
                println("Coroutine 2")
                delay(200)
                throw NullPointerException("Coroutine 2")
            }
            launch {
                println("Coroutine 3")
                delay(400)
                println("Coroutine 3 continue")
                throw ArithmeticException("Coroutine 3")
            }
        }
        job.join()
        delay(1000)
    } // end of runBlocking
}