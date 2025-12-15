package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

fun main() {
    val list: List<Int> = listOf<Int>(1, 8, 9, 3, 6, 7, 2)
    runBlocking {
        // transform
        // biến đổi giá trị trước khi thêm vào list kết quả
        list.asFlow().transform {
            emit(it * it)
            emit(it * it * it)
        }.collect {
            println("value = $it")
        }
    }
}