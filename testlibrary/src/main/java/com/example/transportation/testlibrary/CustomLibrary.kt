package com.example.transportation.testlibrary

import kotlin.random.Random

class CustomLibrary {
    fun testGenerateInt(): Int = Random.nextInt(0, 100)
    fun testGenerateString(): String = "Hello World"

}