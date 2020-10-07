package com.example.transportation.frameworktesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.transportation.testlibrary.cameraActivity.WebPageActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, WebPageActivity::class.java)
        startActivity(intent)
    }
}
