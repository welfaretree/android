package com.example.stac

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class Splash : AppCompatActivity() {

    private val SPLASH_VIEW_TIME: Long = 2000 // 2초간 스플래시 화면 보여줌


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val loginIntent = Intent(this,Login::class.java)
            startActivity(loginIntent)
            finish()
        }, SPLASH_VIEW_TIME)
    }

}