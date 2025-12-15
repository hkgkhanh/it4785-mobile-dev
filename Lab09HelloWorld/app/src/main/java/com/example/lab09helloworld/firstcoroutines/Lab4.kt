package com.example.lab09helloworld.firstcoroutines

import android.util.Log
import com.example.lab09helloworld.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Unconfined
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object TestDispachers4 {
    fun runMyFirstCoroutines() {
        GlobalScope.launch(Dispatchers.Unconfined) {
            Log.d(
                MainActivity::class.java.simpleName, "Before delay - Dispachers Unconfined run on ${Thread.currentThread().name}")
            delay(1000)
            Log.d(
                MainActivity::class.java.simpleName, "Dispachers Unconfined run on ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Main) {
            Log.d(
                MainActivity::class.java.simpleName, "Dispachers Main run on ${Thread.currentThread().name}")
        }
    }
}