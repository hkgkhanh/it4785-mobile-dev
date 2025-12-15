package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
        val time = measureTimeMillis {
            val a: Deferred<Int> = async { doSomethingFunny3() }
            val b: Deferred<Int> = async { doSomethingFunny4() }
            println(a.await() + b.await())
        }
        println("Time = $time")
    }
}
suspend fun doSomethingFunny3(): Int {
    delay(1000)
    return 10
}
suspend fun doSomethingFunny4(): Int {
    delay(1000)
    return 20
}