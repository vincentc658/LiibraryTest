package com.example.transportation.testlibrary

import android.util.Log
import kotlin.random.Random

class CustomLibrary {
    companion object Builder {
        private const val TAG = "LIB_EXAMPLE_ANDROID_THIRD"

        fun i(message:String){
            Log.i(TAG, message)
        }
        fun testGenerateInt(): Int = Random.nextInt(0, 100)
        fun testGenerateString(): String = "Hello World"
    }


}