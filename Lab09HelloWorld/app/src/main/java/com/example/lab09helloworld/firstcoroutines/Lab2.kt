package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        println("Current Thread: ${Thread.currentThread().name}")
        delay(1000)
        println("Hello ")
        delay(1000)
        println("World ")
    }
    println("Current Thread: ${Thread.currentThread().name}")
    println("After runBlocking")
}