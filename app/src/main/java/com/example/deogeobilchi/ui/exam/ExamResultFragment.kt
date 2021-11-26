package com.example.deogeobilchi.ui.exam

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deogeobilchi.databinding.FragmentExamResultBinding
import com.example.deogeobilchi.ui.exam.adapter.JobAdapter
import com.example.deogeobilchi.ui.exam.adapter.ResultAdapter

class ExamResultFragment(mViewModel: ExamViewModel) : Fragment() {
    private val TAG = "TAGexam"
    private var _binding: FragmentExamResultBinding? = null
    private val binding get() = _binding!!
    private lateinit var mJobAdapter: JobAdapter
    private lateinit var mResultAdapter: ResultAdapter
    private val viewModel: ExamViewModel = mViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentExamResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mJobAdapter = JobAdapter()
        mJobAdapter.list = viewModel.resultTypeList
        mJobAdapter.notifyDataSetChanged()

        mResultAdapter = ResultAdapter()
        mResultAdapter.list = viewModel.resultTypeList
        mResultAdapter.notifyDataSetChanged()

        binding.apply {
            jobAdapter = mJobAdapter
            resultAdapter = mResultAdapter

            rvJobList.apply {
                layoutManager = LinearLayoutManager(context)
                isNestedScrollingEnabled = false
            }
            rvResultList.apply {
                layoutManager = LinearLayoutManager(context)
                isNestedScrollingEnabled = false
            }
        }
    }
}