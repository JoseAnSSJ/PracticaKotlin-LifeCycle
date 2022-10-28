package com.example.lifecycle

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var pos: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("prue", "onCreate")
        findViewById<MaterialButton>(R.id.btnCheck).setOnClickListener{
            startActivity(Intent(this,Dialog::class.java))
        }
    }

    override fun onStart() {
        super.onStart()
        mediaPlayer = MediaPlayer.create(this,R.raw.ai_1)
        mediaPlayer?.start()
        Log.i("prue", "onStart")
    }

    override fun onResume() {
        super.onResume()
        mediaPlayer?.seekTo(pos)
        mediaPlayer?.start()
        Log.i("prue", "onResume")
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer?.pause()
        if (mediaPlayer != null){
            pos = mediaPlayer!!.currentPosition
        }

        Log.i("prue", "onPause")
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.stop()
        mediaPlayer?.release()
        mediaPlayer = null
        Log.i("prue", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("prue", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("prue", "onDestroy")

    }
}