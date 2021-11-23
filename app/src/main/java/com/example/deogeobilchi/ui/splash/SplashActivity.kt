package com.example.deogeobilchi.ui.splash

import android.os.Bundle
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

        startActivity<LoginActivity>(this, 3000)
    }
}