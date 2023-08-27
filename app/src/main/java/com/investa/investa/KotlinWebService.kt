package com.investa.investa
/*
*
*  Written by Obed Ojingwa, gmail= obedojingwa@gmail.com
 I will be happy to work with you
 *
 *
 * */


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.Manifest
import android.content.pm.PackageManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class KotlinWebService : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_web_service)


        // Check for internet permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.INTERNET), 123)
        } else {
            setupViews()
            setupWebView()
        }
    }

    private fun setupViews() {
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)

        // Configure the refresh action
        swipeRefreshLayout.setOnRefreshListener {
            webView.reload()
        }
    }

    private fun setupWebView() {
        webView = findViewById(R.id.webView)

        // Enable JavaScript (if needed)
        webView.settings.javaScriptEnabled = true

        // Set a WebViewClient to open URLs in the WebView
        webView.webViewClient = WebViewClient()

        // Load the URL
        webView.loadUrl(" www.example.uk")
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }


}