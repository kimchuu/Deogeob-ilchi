package com.example.deogeobilchi.ui.exam

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.deogeobilchi.DeogeobilchiApplication
import com.example.deogeobilchi.DeogeobilchiApplication.Companion.prefs
import com.example.deogeobilchi.R
import com.example.deogeobilchi.databinding.FragmentExamBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class ExamFragment(viewModel: ExamViewModel) : Fragment() {
    private val TAG = "TAGexam"
    private var _binding: FragmentExamBinding ? = null
    private val binding get() = _binding!!
    private val viewModel: ExamViewModel = viewModel

    private var mChecked = 0 

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExamBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeQuestion()
        observeNumber()

        binding.apply {
            backBtn.setOnClickListener {
                viewModel.prevQuestion()
            }

            prefs.clear()
            radioGroup.setOnCheckedChangeListener { radioGroup, i ->
                when(i){
                    R.id.radio_btn_1 -> mChecked = 1
                    R.id.radio_btn_2 -> mChecked = 2
                    R.id.radio_btn_3 -> mChecked = 3
                    R.id.radio_btn_4 -> mChecked = 4
                    R.id.radio_btn_5 -> mChecked = 5
                }
            }

            nextBtn.setOnClickListener {
                viewModel.updateAnswerMap(mChecked)
                viewModel.nextQuestion()
                mChecked = 0
                binding.radioGroup.clearCheck()

                if (viewModel.number.value!! >= 25) { // 검사 끝
                    // next btn 대신 완료 버튼 등장
                    viewModel.resultAnswerMap()
                    Log.d(TAG, "nextQuestion: answerList = ${viewModel.answerList}")

                }
            }
            
        }
    }

    private fun observeQuestion() {
        viewModel.question.observe(
            viewLifecycleOwner,
            Observer {
                binding.question = it
            }
        )
    }

    private fun observeNumber() {
        viewModel.number.observe(
            viewLifecycleOwner,
            Observer {
                binding.number = String.format("%02d", it)
            }
        )
    }
}