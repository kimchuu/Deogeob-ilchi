package com.example.deogeobilchi.ui.login

import android.os.Bundle
import com.example.deogeobilchi.R
import com.example.deogeobilchi.base.BaseActivity
import com.example.deogeobilchi.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity() {
    val binding by binding<ActivityLoginBinding>(R.layout.activity_login)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply { }
    }
}