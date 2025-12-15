package com.example.lab09helloworld.firstcoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    val job1: Job = GlobalScope.launch {
        delay(2000)
        println("Hello Kotlin")
    }
    val job2: Job = GlobalScope.launch {
        // job2 chờ đợi công việc của job1 hoàn thành rồi mới thực hiện
        job1.join()
        delay(1000)
        println("I'm Coroutine")
    }
    Thread.sleep(4000)
}