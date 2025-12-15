package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

fun main() {
    val list: List<Int> = listOf<Int>(1, 8, 9, 3, 6, 7, 2)
    runBlocking {
        // take: lấy số lượng giá trị nhất định. Ví dụ như lấy 3 giá trị đầu tiên
        list.asFlow().take(3).collect {
            println("value = $it")
        }
    }
}