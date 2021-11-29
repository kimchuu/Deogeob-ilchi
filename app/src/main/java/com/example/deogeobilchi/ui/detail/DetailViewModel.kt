package com.example.deogeobilchi.ui.detail

import com.example.deogeobilchi.base.BaseViewModel
import com.example.deogeobilchi.data.work.WorkRepositoryImpl
import com.example.deogeobilchi.model.WorkDetailModel
import com.example.deogeobilchi.model.WorkModel

class DetailViewModel(
    private val workRepository: WorkRepositoryImpl
) : BaseViewModel()  {
    lateinit var work : WorkModel
    lateinit var workDetail : WorkDetailModel
    var workDetails = mutableListOf<WorkDetailModel>()

    init {
        setWorkDetails()
    }

    fun getWorkDetail(){
        workDetail = workDetails.find {
            it.company == work.company
        }!! // 예외처리 해야함

    }

    fun setWorkDetails(){
        var mDetail =  WorkDetailModel("(주)NAVER", "대기업", "1999년 6월 2일", "4조 1266억 2931만원")
        workDetails.add(0, mDetail)

        mDetail =  WorkDetailModel("(주)카카오뱅크", "대기업", "2016년 1월 22일", "8041억 5천만원")
        workDetails.add(1, mDetail)

        mDetail =  WorkDetailModel("(주)당근마켓", "스타트업", "2015년 6월 15일", "-")
        workDetails.add(2, mDetail)
    }
}