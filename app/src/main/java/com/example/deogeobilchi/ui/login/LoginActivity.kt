package com.example.deogeobilchi.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.databinding.BindingAdapter
import com.example.deogeobilchi.R
import com.example.deogeobilchi.base.BaseActivity
import com.example.deogeobilchi.databinding.ActivityLoginBinding
import com.example.deogeobilchi.ui.exam.ExamActivity

class LoginActivity : BaseActivity() {
    private val binding by binding<ActivityLoginBinding>(R.layout.activity_login)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.apply { }
    }

    @BindingAdapter("bind: onClick")
    fun gotoTest(){
        startActivity<ExamActivity>(this)
    }
}