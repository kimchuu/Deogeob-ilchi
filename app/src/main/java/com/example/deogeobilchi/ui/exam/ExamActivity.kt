package com.example.deogeobilchi.ui.exam

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.deogeobilchi.R
import com.example.deogeobilchi.base.BaseActivity
import com.example.deogeobilchi.databinding.ActivityExamBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ExamActivity : BaseActivity(), ExamInterface {
    private val TAG = "TAGexam"
    private val binding by binding<ActivityExamBinding>(R.layout.activity_exam)
    private lateinit var examFragment: ExamFragment
    private lateinit var resultFragment: ExamResultFragment
    private val viewModel: ExamViewModel by viewModel()
    private val mInterface = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            isStart = false
            isResult = false

            btnFloatingBar.setOnClickListener {
                isStart = true

                examFragment = ExamFragment(viewModel, mInterface)
                setFragment(examFragment)
            }

            tvTitleExam.setOnClickListener {
                examFinish()
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

    private fun setFragment(mFragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.exam_frame, mFragment)
            .commit()
    }

    override fun examFinish() {
        resultFragment = ExamResultFragment(viewModel)
        setFragment(resultFragment)

        binding.apply {
            isStart = false
            isResult = true
            tvTitleExam.text = applicationContext.getString(R.string.exam_finish)
            tvFloatingBar.text = applicationContext.getString(R.string.goto_main)
        }
    }
}