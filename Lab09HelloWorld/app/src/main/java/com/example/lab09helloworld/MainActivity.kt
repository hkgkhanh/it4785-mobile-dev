package com.example.lab09helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.lab09helloworld.firstcoroutines.TestDispatchers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TestDispatchers.runMyFirstCoroutines()
    }
}