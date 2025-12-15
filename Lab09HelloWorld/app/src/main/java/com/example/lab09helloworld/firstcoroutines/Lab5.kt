package com.example.lab09helloworld.firstcoroutines

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun testMySecondWithContext() {
    var n : Int = 10
    GlobalScope.launch(Dispatchers.IO) {
        // Run long time task
        Log.d("myLog", "Run long time task - Thread: ${Thread.currentThread().name}")
        delay(2000)
        n += 20
        withContext(Dispatchers.Main) {
            // Update UI here
            Log.d("myLog", "Update UI - Thread: ${Thread.currentThread().name} n = $n")
        }
    }
}