package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() {
    runBlocking {
        withTimeout(1800) {
            repeat(1000) {
                println("I'm sleeping $it")
                delay(500)
            }
        }
    }
}
