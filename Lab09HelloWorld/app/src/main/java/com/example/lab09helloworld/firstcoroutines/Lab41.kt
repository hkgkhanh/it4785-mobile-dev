package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

fun main() {
    val list: List<Int> = listOf<Int>(1, 8, 9, 3, 6, 7, 2)
    runBlocking {
        list.asFlow().filter {
            it % 2 == 0
        }.map {it * 2 }
            .take(2)
            .collect {
                println("value = $it")
            }
    }
}