package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val foo = foo(200)
        foo2(5).collect {
            println("i = $it")
        }
    }
}
fun foo2(n : Int): Flow<Int> = flow {
    for(i in 0..n) {
        delay(1000)
        emit(i)
    }
}