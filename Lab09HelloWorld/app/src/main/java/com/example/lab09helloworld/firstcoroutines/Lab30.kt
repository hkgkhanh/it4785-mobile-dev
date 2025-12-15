package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.supervisorScope

fun main() {
    runBlocking {
        supervisorScope {
            val firstChild = launch {
                println("Print from First Child")
                throw NullPointerException()
            }
            val secondChild = launch {
                firstChild.join()
                println("print from second Child. First Child is Active: ${firstChild.isActive}")
                try {
                    delay(1000)
                } finally {
                    println("Second Child Cancelled")
                }
            }
            firstChild.join()
            secondChild.join()
        }
    }
}