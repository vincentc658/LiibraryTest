package com.example.transportation.testlibrary.cameraActivity

import android.hardware.camera2.CameraCaptureSession
import android.hardware.camera2.CameraDevice
import android.hardware.camera2.CameraManager
import android.hardware.camera2.CaptureRequest
import android.os.Bundle
import android.view.TextureView
import androidx.appcompat.app.AppCompatActivity
import com.example.transportation.testlibrary.R


class CameraActivity  : AppCompatActivity(){
    private var myCameraCaptureSession: CameraCaptureSession? = null
    private var myCameraID: String? = null
    private var myCameraManager: CameraManager? = null
    private var myCameraDevice: CameraDevice? = null
    private var myTextrureView: TextureView? = null
    private var myCaptureRequestBuilder: CaptureRequest.Builder? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

    }

}