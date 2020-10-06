package com.example.transportation.testlibrary.cameraActivity

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.transportation.testlibrary.R
import kotlinx.android.synthetic.main.web_view_activity.*
import org.json.JSONObject


class ViewLinkOnWebView : AppCompatActivity() {
    private var mUploadMessage: ValueCallback<Array<Uri>>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_view_activity)
        onInitialize()
        onClick()
    }

    override fun onBackPressed() {
        if (wvWeb.canGoBack()) {
            wvWeb.goBack()
        } else {
            super.onBackPressed()
        }
    }

    private fun onInitialize() {
        wvWeb.settings.javaScriptCanOpenWindowsAutomatically = true
        wvWeb.settings.javaScriptEnabled = true
        wvWeb.settings.allowFileAccess = true
        wvWeb.settings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
        wvWeb.settings.useWideViewPort = true
        wvWeb.settings.setGeolocationEnabled(true)
        wvWeb.settings.setAppCacheEnabled(true)
        wvWeb.settings.databaseEnabled = true
        wvWeb.settings.domStorageEnabled = true
        wvWeb.addJavascriptInterface(WebVCamBridgeInterface(), "Android")
        wvWeb.loadUrl("http://35.202.109.216/camera")

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 200) {
            data?.let {
                val dataImage = data.getStringExtra("dataImage")
                dataImage?.let {
                    Log.d("data masuk", CacheImage.getCacheImage(this))
                    wvWeb.evaluateJavascript(
                        "javascript: " +"updateFromNative(\"" + CacheImage.getCacheImage(this)+ "\")",
                        null)
                }
            }
        }
    }

    private fun onClick() {

    }


    inner class WebVCamBridgeInterface {
        @JavascriptInterface
        fun showAndroidCamera(jsonString: String) {


            val afterReplace = jsonString.replace("\\", "");
            val finalJsonString = afterReplace.substring(1, afterReplace.length - 1)
            val jo = JSONObject(finalJsonString)
            val isFrontCamera = jo.getInt("isFrontCamera")
            val instruction = jo.getString("title")
            val intent = Intent(this@ViewLinkOnWebView, Camera2Activity::class.java)
            intent.putExtra("isFrontCamera", isFrontCamera)
            intent.putExtra("instruction", instruction)
            startActivityForResult(intent, 200)

        }
    }
}
