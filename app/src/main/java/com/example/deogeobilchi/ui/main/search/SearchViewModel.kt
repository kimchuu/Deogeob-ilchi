package com.example.deogeobilchi.ui.main.search

import androidx.lifecycle.viewModelScope
import com.example.deogeobilchi.R
import com.example.deogeobilchi.base.BaseViewModel
import com.example.deogeobilchi.data.work.WorkRepositoryImpl
import com.example.deogeobilchi.model.EnumExamType
import com.example.deogeobilchi.model.WorkModel
import kotlinx.coroutines.launch

class SearchViewModel(
    private val workRepository: WorkRepositoryImpl
) : BaseViewModel() {
    //val works: LiveData<MutableList<WorkModel>> = workRepository.getAllData().asLiveData()
    var companyList = mutableListOf<WorkModel>()

    fun setData() {
        addData("(주)NAVER", "[NAVER Cloud] 네이버 프론트엔드 직업체험", R.drawable.naver_image)
        addData("(주)카카오뱅크", "[뉴플랫폼기술] 클라우드 엔지니어", R.drawable.kakao_bank)
        addData("(주)당근마켓", "백엔드 개발 인턴", R.drawable.daangn)
    }

    private fun addData(company: String, work: String, image: Int) {
        var id = company + "_" + work
        var mWorkModel = WorkModel(id, company, work, EnumExamType.R, image, 5, false)
        companyList.add(mWorkModel)

        viewModelScope.launch {
            workRepository.insert(mWorkModel)
        }
    }
}