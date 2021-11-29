package com.example.deogeobilchi.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.deogeobilchi.R
import com.example.deogeobilchi.base.BaseActivity
import com.example.deogeobilchi.databinding.ActivityDetailBinding
import com.example.deogeobilchi.model.WorkModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity() {
    private val binding by binding<ActivityDetailBinding>(R.layout.activity_detail)
    private lateinit var detailFragment: DetailFragment
    private val viewModel : DetailViewModel by viewModel()
    private var mWhere = "상세정보"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        detailFragment = DetailFragment(viewModel)

        getExtra("work")

        binding.apply {
            where = mWhere
            setFragment(detailFragment)
            isApply = false
            floatingText = applicationContext.getString(R.string.apply)

            btnApplyFloatingBar.setOnClickListener {
                isApply = true
                floatingText = applicationContext.getString(R.string.summit)
            }

            btnSummitFloatingBar.setOnClickListener {
                "제출이 완료되었습니다".showLongToast()
                finish()
            }
       }

    }

    private fun setFragment(mFragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .setCustomAnimations(R.anim.fadein, R.anim.fadeout)
            .replace(R.id.detail_frame, mFragment)
            .commit()
    }

    private fun getExtra(key : String){
        if (intent.getSerializableExtra(key) != null) {
            viewModel.work = intent.getSerializableExtra(key) as WorkModel
        }
    }
}