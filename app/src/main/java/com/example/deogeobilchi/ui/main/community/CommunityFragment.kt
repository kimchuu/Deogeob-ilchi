package com.example.deogeobilchi.ui.main.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deogeobilchi.databinding.FragmentCommunityBinding
import com.example.deogeobilchi.ui.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CommunityFragment : Fragment() {
    private var _binding: FragmentCommunityBinding? = null
    private val binding get() = _binding!!
    private lateinit var mCommunityAdapter: CommunityAdapter
    private val viewModel: MainViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCommunityBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setCommunityData()
        mCommunityAdapter = CommunityAdapter()
        mCommunityAdapter.list = viewModel.communityList

        binding.apply {
            adapter = mCommunityAdapter
            rvCommunity.apply {
                layoutManager = LinearLayoutManager(context)
            }
        }
    }
}