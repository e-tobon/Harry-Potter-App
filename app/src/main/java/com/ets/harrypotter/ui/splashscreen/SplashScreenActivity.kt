package com.ets.harrypotter.ui.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ets.harrypotter.MainActivity
import com.ets.harrypotter.R
import kotlin.concurrent.thread

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        val intentSplash = Intent(this,MainActivity::class.java)
        thread {
            Thread.sleep(3000)
            startActivity(intentSplash)
            finish()
        }
    }
}