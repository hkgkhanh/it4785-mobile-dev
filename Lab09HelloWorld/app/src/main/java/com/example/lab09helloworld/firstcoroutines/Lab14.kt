package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {
        val result = withTimeoutOrNull(1800) {
            repeat(1000) {
                println("I'm sleeping $it")
                delay(500)
            }
            "Done"
        }
        println("Result = $result")
    }
}