package com.example.deogeobilchi.ui.main

import androidx.lifecycle.viewModelScope
import com.example.deogeobilchi.R
import com.example.deogeobilchi.base.BaseViewModel
import com.example.deogeobilchi.data.work.WorkRepositoryImpl
import com.example.deogeobilchi.model.CommunityModel
import com.example.deogeobilchi.model.EnumExamType
import com.example.deogeobilchi.model.WorkModel
import kotlinx.coroutines.launch

class MainViewModel(
    private val workRepository: WorkRepositoryImpl
) : BaseViewModel() {
    //val works: LiveData<MutableList<WorkModel>> = workRepository.getAllData().asLiveData()
    var companyList = mutableListOf<WorkModel>()
    var communityList = mutableListOf<CommunityModel>()

    fun setWorkData() {
        addWorkData("(주)NAVER", "[NAVER Cloud] 네이버 프론트엔드 직업체험", R.drawable.naver_image)
        addWorkData("(주)카카오뱅크", "[뉴플랫폼기술] 클라우드 엔지니어", R.drawable.kakao_bank)
        addWorkData("(주)당근마켓", "백엔드 개발 인턴", R.drawable.daangn)
    }

    private fun addWorkData(company: String, work: String, image: Int) {
        var id = company + "_" + work
        var mWorkModel = WorkModel(id, company, work, EnumExamType.R, image, 5, false)
        companyList.add(mWorkModel)

        viewModelScope.launch {
            workRepository.insert(mWorkModel)
        }
    }

    fun setCommunityData() {
        addCommunityData("이 성적으로 숭실대 갈 수 있을까?", "오늘 모의고사를 봤는데... 국어는 1등급, 수학은 1등급, 영어는 2등급 이렇게 나왔습니다ㅜㅜ 숭실대 갈 수 있을까요..?", "31분 전")
        addCommunityData("개발자 취업하려면 뭐부터 공부해야 하나요?", "안드로이드 개발자가 되는 게 꿈이라 이제 조금씩 개발 공부를 해보려고 합니다! 뭐부터 공부해야하나요? 경험담 공유 부탁드려요!", "17시 35분")
        addCommunityData("다들 검사 유형 어떻게 나왔엉?", "진짜 예상치도 못했는데 내가 사회형이 나왔네ㅋㅋㅋㅋㅋㅋ 사회형이면 학생들 가르치는 거 좋아하는 것 같은데 난 공부 못하는디..", "1분 전")
    }

    private fun addCommunityData(title: String, contents: String, time: String) {
        var mCommunity = CommunityModel(title, contents, time, "익명")
        communityList.add(mCommunity)
    }
}