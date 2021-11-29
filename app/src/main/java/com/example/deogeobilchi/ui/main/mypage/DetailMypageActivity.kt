package com.example.deogeobilchi.ui.main.mypage

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.deogeobilchi.R
import com.example.deogeobilchi.base.BaseActivity
import com.example.deogeobilchi.databinding.ActivityDetailMypageBinding
import com.example.deogeobilchi.ui.main.search.SearchFragment

class DetailMypageActivity : BaseActivity() {
    private val binding by binding<ActivityDetailMypageBinding>(R.layout.activity_detail_mypage)
    private var mWhere = ""
    private lateinit var mFragment: Fragment

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