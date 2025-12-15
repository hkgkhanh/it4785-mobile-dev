package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job = launch {
            repeat(3) {
                launch {
                    delay(100)
                    println("coroutine: $it")
                }
            }
            println("Print from parent")
        }
        job.join()
        delay(1000)
    }
}