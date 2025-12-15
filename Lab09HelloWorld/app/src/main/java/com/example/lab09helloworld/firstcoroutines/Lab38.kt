package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.runBlocking

fun main() {
    val list: List<Int> = listOf<Int>(1, 8, 9, 3, 6, 7, 2)
    runBlocking {
        // filter: lọc Flow theo các điều kiện. Ví dụ: lọc lấy các số chẵn
        list.asFlow().filter { it % 2 == 0 }.collect {
            println("value = $it")
        }
    }
}