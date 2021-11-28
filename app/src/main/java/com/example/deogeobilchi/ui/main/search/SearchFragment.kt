package com.example.deogeobilchi.ui.main.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deogeobilchi.databinding.FragmentSearchBinding
import com.example.deogeobilchi.ui.main.adapter.SearchAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var mSearchAdapter: SearchAdapter
    private val viewModel: SearchViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setData()
        mSearchAdapter = SearchAdapter()
        mSearchAdapter.list = viewModel.companyList

        binding.apply {
            adapter = mSearchAdapter
            rvSearch.apply {
                layoutManager = LinearLayoutManager(context)
            }
        }
    }
}