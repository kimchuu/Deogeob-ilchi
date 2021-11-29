package com.example.deogeobilchi.ui.main.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.deogeobilchi.DeogeobilchiApplication.Companion.prefs
import com.example.deogeobilchi.databinding.FragmentSearchBinding
import com.example.deogeobilchi.model.WorkModel
import com.example.deogeobilchi.ui.detail.DetailActivity
import com.example.deogeobilchi.ui.main.MainViewModel
import com.google.gson.Gson
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.Collections.list

class SearchFragment : Fragment() {
    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private lateinit var mSearchAdapter: SearchAdapter
    private val viewModel: MainViewModel by sharedViewModel()
    private var where = "SEARCH"

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

        observeWorks()

        mSearchAdapter = SearchAdapter(
            gotoDetail = { work ->
                Intent(context, DetailActivity::class.java).apply {
                    putExtra("work", work)
                    startActivity(this)
                }
            },
            updateScrap = { isUpdate, work ->
                viewModel.updateLike(isUpdate, work)

            }
        )

        if (mSearchAdapter.list.isNullOrEmpty()) {
            mSearchAdapter.list = viewModel.companyList
        }

        if (this.arguments != null){
            if (this.requireArguments().getString("mypage") == "scrap") {
                where = "MYPAGE"
                binding.searchLayout.visibility = View.GONE
                Log.d("TAGsearch", "onViewCreated: ${this.arguments}")
            }
        } else {
            where = "SEARCH"
        }


        binding.apply {
            adapter = mSearchAdapter
            rvSearch.apply {
                layoutManager = LinearLayoutManager(context)
            }
            search = prefs.getString("myType")
        }

    }

    private fun observeWorks(){
        viewModel.works.observe(
            viewLifecycleOwner,
            Observer {
                mSearchAdapter.list = it
                getScraps(it)
            }
        )
    }

    private fun getScraps(it : MutableList<WorkModel>){
        if (where == "MYPAGE") {
            mSearchAdapter.list = it.filter {
                it.isLike == true
            } as MutableList<WorkModel>
            mSearchAdapter.notifyDataSetChanged()

            Log.d("TAGsearch", "getScraps: ${mSearchAdapter.list}")
        }
    }

}