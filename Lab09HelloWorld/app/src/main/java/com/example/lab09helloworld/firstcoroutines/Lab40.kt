package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.runBlocking

fun main() {
    val list: List<Int> = listOf<Int>(1, 8, 9, 3, 6, 7, 2)
    runBlocking {
        // fold: giống như reduce nhưng có thể đặt giá trị khởi đầu
        val sum: Int = list.asFlow().fold(5) { accumulator, value ->
            println("accumulatior = $accumulator and value = $value")
            accumulator + value
        }
        println("sum = $sum")
    }
}