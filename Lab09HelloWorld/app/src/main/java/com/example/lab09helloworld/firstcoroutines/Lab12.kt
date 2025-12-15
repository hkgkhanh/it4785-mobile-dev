package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.NonCancellable
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

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
                withContext(NonCancellable) {
                    repeat(2) {
                        delay(100)
                        println("Print from NonCancellable")
                    }
                }
            }
        }
        delay(300)
        println("I want stop coroutine")
        job.cancel()
    }
}