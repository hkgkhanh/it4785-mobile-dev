package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    GlobalScope.launch {
        println("Current Thread: ${Thread.currentThread().name}")
        delay(1000)
        print("Hello ")
    }
    println("Current Thread: ${Thread.currentThread().name}")
    print("World ")
    Thread.sleep(2000)
}