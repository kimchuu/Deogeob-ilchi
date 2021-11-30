package com.example.deogeobilchi.ui.main.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.deogeobilchi.R
import com.example.deogeobilchi.base.BaseActivity
import com.example.deogeobilchi.databinding.ActivityDetailMypageBinding
import com.example.deogeobilchi.ui.detail.ResumeFragment
import com.example.deogeobilchi.ui.exam.ExamResultFragment
import com.example.deogeobilchi.ui.exam.ExamViewModel
import com.example.deogeobilchi.ui.main.search.SearchFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailMypageActivity : BaseActivity() {
    private val binding by binding<ActivityDetailMypageBinding>(R.layout.activity_detail_mypage)
    private var mWhere = ""
    private lateinit var mFragment: Fragment
    private val examViewModel: ExamViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            btnBack.setOnClickListener { finish() }
        }

        mWhere = intent.getStringExtra("mypage").toString()

        when(mWhere){
            "scrap" -> {
                binding.where = "스크랩한 기업"
                mFragment = SearchFragment()
            }
            "resume" -> {
                binding.where = "이력서 관리"
                mFragment = ResumeFragment()
            }
            "examResult" -> {
                binding.where = "검사 결과"
                mFragment = ExamResultFragment(examViewModel)
            }
            "applied" -> {
                binding.where = "지원한 기업"
                mFragment = SearchFragment()
            }
            "finished" -> {
                binding.where = "체험완료한 기업"
                mFragment = SearchFragment()
            }
        }
        sendBundle(mFragment, mWhere)
        setFragment(mFragment)

    }

    private fun setFragment(mFragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.fadein, R.anim.fadeout)
            .add(R.id.mypage_frame, mFragment)
            .commit()
    }

    private fun sendBundle(fragment : Fragment, value : String){
        val bundle = Bundle()
        bundle.putString("mypage", value)

        fragment.arguments = bundle
    }
}