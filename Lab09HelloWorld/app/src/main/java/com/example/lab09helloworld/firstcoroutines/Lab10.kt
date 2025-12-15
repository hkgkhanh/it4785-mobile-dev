package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job = launch {
            try {
                repeat(1000) {
                    delay(100)
                    println("Hello Coroutine")
                }
            } finally {
                println("Print from finally")
            }
        }
        delay(300)
        println("I want to stop coroutine")
        job.cancel()
    }
}