package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.runBlocking

fun main() {
    val list: List<Int> = listOf<Int>(1, 8, 9, 3, 6, 7, 2)
    runBlocking {
        // reduce: Tính cộng dồn các phần tử của Flow.
        // Ví dụ: tính tổng các phần tử trong list
        val sum: Int = list.asFlow().reduce { accumulator, value ->
            println("accumulatior = $accumulator and value = $value")
            accumulator + value
        }
        println("sum = $sum")
    }
}