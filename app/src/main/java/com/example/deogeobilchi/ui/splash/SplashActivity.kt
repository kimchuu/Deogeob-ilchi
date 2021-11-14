package com.example.deogeobilchi.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.deogeobilchi.R
import com.example.deogeobilchi.base.BaseActivity
import com.example.deogeobilchi.databinding.ActivitySplashBinding
import com.example.deogeobilchi.ui.login.LoginActivity

class SplashActivity : BaseActivity() {
    val binding by binding<ActivitySplashBinding>(R.layout.activity_splash)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply { }

        binding.loadingLottie.playAnimation()

        val handler: Handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}