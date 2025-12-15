package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job = launch(Dispatchers.Default) {
            repeat(1000) {
                delay(500)
                println("I'm sleeping $it ...")
            }
        }
        delay(1500)
        job.cancel()
        print("Cancelled coroutines")
    }
}
