package com.example.deogeobilchi.ui.main.mypage

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.deogeobilchi.DeogeobilchiApplication.Companion.prefs
import com.example.deogeobilchi.R
import com.example.deogeobilchi.databinding.FragmentMypageBinding
import com.example.deogeobilchi.model.EnumExamType
import com.example.deogeobilchi.ui.detail.DetailActivity
import com.example.deogeobilchi.ui.main.search.SearchFragment

class MypageFragment : Fragment() {
    private var _binding: FragmentMypageBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMypageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            if (prefs.getStringList("myType") != null) {
                val firstType: EnumExamType = prefs.getStringList("myType")!![0]
                type = "# " + firstType.type
            }

            scrapBtn.setOnClickListener {
                gotoDetail("scrap")
            }

            resumeBtn.setOnClickListener{
                gotoDetail("resume")
            }

            examResultBtn.setOnClickListener {
                gotoDetail("examResult")
            }

            appliedBtn.setOnClickListener {
                gotoDetail("applied")
            }

            finishedBtn.setOnClickListener {
                gotoDetail("finished")
            }
        }
    }

    private fun gotoDetail(value : String){
        Intent(context, DetailMypageActivity::class.java).apply {
            putExtra("mypage", value)
            startActivity(this)
        }
    }

}