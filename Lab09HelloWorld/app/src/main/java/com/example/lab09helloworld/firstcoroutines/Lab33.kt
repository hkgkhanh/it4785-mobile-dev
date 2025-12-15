package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {
        withTimeoutOrNull(3000) {
            foo3(10).collect {
                println("i = $it")
            }
        }
    }
}fun foo3(n : Int) : Flow<Int> = flow {
    for (i in 0..n) {
        delay(1000)
        emit(i)
    }
}