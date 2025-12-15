package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

fun main() {
    val list: List<Int> = listOf<Int>(1, 8, 9, 3, 6, 7, 2)
    runBlocking {
        val nums = (1..3).asFlow().onEach {
            delay(100)
        }
        val strs = listOf("one", "two", "three").asFlow().onEach {
            delay(400)
        }
        var startTime = System.currentTimeMillis()
        nums.zip(strs) { num, str ->
            "(num = $num and str = $str)"
        }.collect {
            println("value = $it at ${System.currentTimeMillis() - startTime} ")
        }
        println("=============================")
        startTime = System.currentTimeMillis()
        nums.combine(strs) { num, str ->
            "(num = $num and str = $str)"
        }.collect {
            println("value = $it at ${System.currentTimeMillis() - startTime} ")
        }
    }
}