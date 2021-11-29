package com.example.deogeobilchi.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.deogeobilchi.databinding.FragmentDetailBinding

class DetailFragment(detailViewModel: DetailViewModel) : Fragment() {
    private var _binding : FragmentDetailBinding ?= null
    private val binding get() = _binding!!
    private var viewModel = detailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getWorkDetail()
        var item = viewModel.workDetail

        binding.apply {
            company = item.company
            scale = item.scale
            foundingDate = item.foundingDate
            sales = item.sales
            work = viewModel.work.work
            ivCompany.setImageResource(viewModel.work.image)
        }
    }
}