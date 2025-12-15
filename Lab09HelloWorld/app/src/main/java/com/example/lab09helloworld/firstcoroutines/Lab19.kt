package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job1 = launch {
            launch {
                delay(100)
                println("coroutine 1: Hello")
                delay(1000)
                println("coroutine 1: Goodbye")

            }
            launch {
                delay(100)
                println("coroutine 2: Hello")
                delay(1000)
                println("coroutine 2: Goodbye")

            }
            GlobalScope.launch {
                delay(100)
                println("coroutine 3: Hello")
                delay(1000)
                println("coroutine 3: Goodbye")
            }
        }

        delay(500)
        job1.cancel()
        delay(2500)
    }
}