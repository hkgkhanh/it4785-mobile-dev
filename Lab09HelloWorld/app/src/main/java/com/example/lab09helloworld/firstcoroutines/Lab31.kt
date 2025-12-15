package com.example.lab09helloworld.firstcoroutines

fun foo(n: Int) : Sequence<Int> = sequence {
    for (i in 0..n) {
        if (i % 2 == 0)
            yield(i)
    }
}
fun main() {
    foo(10).forEach {
        println(it)
    }
}