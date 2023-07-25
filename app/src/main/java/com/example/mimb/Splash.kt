package com.example.mimb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler().postDelayed(Runnable {
            val inext: Intent = Intent(this@Splash,MainActivity::class.java)
            startActivity(inext)
            finish()
        },1500)
    }

    }
