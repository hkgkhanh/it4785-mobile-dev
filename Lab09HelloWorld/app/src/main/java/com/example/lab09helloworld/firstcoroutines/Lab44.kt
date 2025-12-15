package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

fun main() {
    val list: List<Int> = listOf<Int>(1, 8, 9, 3, 6, 7, 2)
    runBlocking {
        val nums = (1..3).asFlow()
        val strs = listOf("one", "two", "three").asFlow()
        nums.zip(strs) { num, str ->
            "(num = $num and str = $str)"
        }.collect {
            println(it)
        }
    }
}