package com.example.deogeobilchi.ui.exam

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.deogeobilchi.base.BaseViewModel

class ExamViewModel : BaseViewModel() {
    private val TAG = "TAGexam"
    var number = MutableLiveData(1)
    var question = MutableLiveData("")
    var questionList = mutableListOf<String>()
    var questionR = mutableListOf<String>() // 현실형
    var questionI = mutableListOf<String>() // 탐구형
    var questionA = mutableListOf<String>() // 예술형
    var questionS = mutableListOf<String>() // 사회형
    var questionE = mutableListOf<String>() // 진취형
    var questionC = mutableListOf<String>() // 관습형
    var answerList = mutableListOf<Int>(0, 0, 0, 0, 0, 0)
    var answerMap = mutableMapOf<Int, Int>()

    init {
        setQuestion()
        makeQuestionList()
        question.value = questionList[number.value!! - 1]
        setAnswerMap()
    }

    private fun setAnswerMap() {
        for (i in 1..24) {
            answerMap[i] = 0
        }
    }

    fun updateAnswerMap(num: Int) {
        answerMap[number.value!!] = num
        //Log.d(TAG, "updateAnswerMap: answerList = ${answerMap}")
    }

    fun resultAnswerMap() {
        answerMap.forEach {
            when (it.key % 6) {
                1 -> answerList[0] += it.value
                2 -> answerList[1] += it.value
                3 -> answerList[2] += it.value
                4 -> answerList[3] += it.value
                5 -> answerList[4] += it.value
                0 -> answerList[5] += it.value
            }
        }

        val sortList = mutableListOf<Int>()
        sortList.addAll(answerList)
        sortList.sortDescending()
        val indexList = mutableListOf(0, 0, 0)
        Log.d(TAG, "resultAnswerMap: answerList = $answerList")
        for (i in 0..2) {
            Log.d(TAG, "resultAnswerMap: ${answerList.indexOf(sortList[i])}")
            val index = answerList.indexOf(sortList[i])
            indexList.add(index)
            answerList[index] = -1
        }
    }

    fun nextQuestion() {
        number.value = number.value?.plus(1)
        if (number.value!! <= 24) {
            question.value = questionList[number.value!! - 1]
        }
    }

    fun prevQuestion() {
        number.value = number.value?.minus(1)
        if (number.value!! >= 1) {
            question.value = questionList[number.value!! - 1]
        }
    }

    private fun makeQuestionList() {
        for (i in 0..3) {
            questionList.add(questionR[i])
            questionList.add(questionI[i])
            questionList.add(questionA[i])
            questionList.add(questionS[i])
            questionList.add(questionE[i])
            questionList.add(questionC[i])
        }
    }

    private fun setQuestion() {
        questionR.add("공구를 사용하여 물건을 고친다")
        questionR.add("화초나 식물을 재배한다")
        questionR.add("기계 장치를 조작한다")
        questionR.add("범죄자를 추척한다")

        questionI.add("실업률 증가 원인에 대해 연구한다")
        questionI.add("물체의 운동법칙을 설명한다")
        questionI.add("경제성장요인의 관계를 분석한다")
        questionI.add("수학의 원리를 탐구한다")

        questionA.add("창작활동을 한다")
        questionA.add("감정을 글로 표현한다")
        questionA.add("시를 감상한다")
        questionA.add("무대에서 공연을 한다")

        questionS.add("사회적으로 소외된 사람들을 도와준다")
        questionS.add("성인이나 아동을 교육 시킨다")
        questionS.add("아픈 사람을 정성껏 간호한다")
        questionS.add("사람의 기분을 잘 맞춘다")

        questionE.add("학교, 학급 및 클럽 등의 대표가 된다")
        questionE.add("학급을 대표하여 학생들의 의견을 잘 전달한다")
        questionE.add("소품이나 운동회 때 친구들을 잘 통솔 한다")
        questionE.add("사람들을 설득해서 물건을 사도록한다")

        questionC.add("용돈이 들어오고 나가는 것을 꼼꼼히 기록한다")
        questionC.add("물건의 가격과 영수증 금액을 일일이 대조한다")
        questionC.add("서류를 분류하고 정리한다")
        questionC.add("학급비 지출내용을 잘 정리한다")
    }
}