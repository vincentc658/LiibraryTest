package com.example.transportation.testlibrary

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.transportation.testlibrary.cameraActivity.Camera2Activity
import kotlinx.android.synthetic.main.testing_library_activity.*

class TestingLibraryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.testing_library_activity)
        tvGoToCamera.setOnClickListener {
            val intent = Intent(this,Camera2Activity::class.java )
            startActivity(intent)
        }
    }
}