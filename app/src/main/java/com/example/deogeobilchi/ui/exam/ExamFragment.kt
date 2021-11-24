package com.example.deogeobilchi.ui.exam

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.deogeobilchi.databinding.FragmentExamBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.*

class ExamFragment(viewModel: ExamViewModel) : Fragment() {
    private var _binding: FragmentExamBinding ? = null
    private val binding get() = _binding!!
    private val viewModel: ExamViewModel = viewModel

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

            nextBtn.setOnClickListener {
                viewModel.nextQuestion()
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