package com.bmwgroup.oneupdatelargetest


import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val videoview = findViewById<View>(R.id.videoView) as VideoView
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.navi_video)

        val mediaController: MediaController = MediaController(this)
        mediaController.setAnchorView(videoview)
        videoview.setMediaController(mediaController)
        videoview.setVideoURI(uri)

        videoview.start()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}