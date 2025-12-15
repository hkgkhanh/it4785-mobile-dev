package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val time = measureTimeMillis {
            val a = doSomethingFunny1()
            val b = doSomethingFunny2()
            println("a + b = ${a + b}")

        }
        println("Time = $time")
    }
}
suspend fun doSomethingFunny1(): Int {
    delay(1000)
    return 10
}
suspend fun doSomethingFunny2(): Int {
    delay(1000)
    return 20
}