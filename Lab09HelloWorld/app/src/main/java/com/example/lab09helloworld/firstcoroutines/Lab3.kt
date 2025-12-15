package com.example.lab09helloworld.firstcoroutines

import android.util.Log
import com.example.lab09helloworld.MainActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object TestDispatchers {
    fun runMyFirstCoroutines() {
        GlobalScope.launch(Dispatchers.Default) {
            Log.d(
                MainActivity::class.java.simpleName, "Dispatchers Default run on ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.IO) {
            Log.d(
                MainActivity::class.java.simpleName, "Dispatchers IO run on ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Unconfined) {
            Log.d(
                MainActivity::class.java.simpleName, "Dispatchers Unconfined run on ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Main) {
            Log.d(
                MainActivity::class.java.simpleName, "Dispatchers Main run on ${Thread.currentThread().name}")
        }
    }
}