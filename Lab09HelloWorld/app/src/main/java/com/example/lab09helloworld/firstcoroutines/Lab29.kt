package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val supervisorJob = SupervisorJob()
        with(CoroutineScope(coroutineContext + supervisorJob)) {
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
            println("Cancelling SupervisorJob")
            supervisorJob.cancel()
            secondChild.join()
        }
    }
}