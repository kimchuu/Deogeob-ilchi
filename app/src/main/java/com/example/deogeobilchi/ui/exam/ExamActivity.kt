package com.example.deogeobilchi.ui.exam

import android.os.Bundle
import com.example.deogeobilchi.R
import com.example.deogeobilchi.base.BaseActivity
import com.example.deogeobilchi.databinding.ActivityExamBinding

class ExamActivity : BaseActivity() {
    private val TAG = "TAGexam"
    private val binding by binding<ActivityExamBinding>(R.layout.activity_exam)
    private lateinit var mFragment: ExamFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            isStart = false

            btnExamStart.setOnClickListener {
                isStart = true

                mFragment = ExamFragment()
                supportFragmentManager.beginTransaction()
                    .replace(R.id.exam_frame, mFragment)
                    .commit()
            }
        }
    }
}