package com.example.transportation.frameworktesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.transportation.testlibrary.TestingLibraryActivity
import com.example.transportation.testlibrary.cameraActivity.ViewLinkOnWebView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this, ViewLinkOnWebView::class.java)
        startActivity(intent)
    }
}
