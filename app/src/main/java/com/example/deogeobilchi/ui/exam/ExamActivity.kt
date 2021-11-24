package com.example.deogeobilchi.ui.exam

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.deogeobilchi.R
import com.example.deogeobilchi.base.BaseActivity
import com.example.deogeobilchi.databinding.ActivityExamBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExamActivity : BaseActivity() {
    private val TAG = "TAGexam"
    private val binding by binding<ActivityExamBinding>(R.layout.activity_exam)
    private lateinit var mFragment: ExamFragment
    private val viewModel: ExamViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            isStart = false

            btnExamStart.setOnClickListener {
                isStart = true

                mFragment = ExamFragment(viewModel)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.exam_frame, mFragment)
                    .commit()
            }
        }

        observeNumber()
    }

    private fun observeNumber() {
        viewModel.number.observe(
            this,
            Observer {
                binding.count = it
                binding.progressBar.progress = it
            }
        )
    }
}