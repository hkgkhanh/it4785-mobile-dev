package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.runBlocking

fun main() {
    val list: List<Int> = listOf<Int>(1, 8, 9, 3, 6, 7, 2)
    runBlocking {
        (1..10).asFlow().single()
    }
}