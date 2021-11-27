package com.example.deogeobilchi.model

enum class EnumExamType(val type: String) {
    R("현실형"),
    I("탐구형"),
    A("예술형"),
    S("사회형"),
    E("진취형"),
    C("관습형")
}

data class ExamTypeDetail(
    var job: MutableList<String>,
    var feature: MutableList<String>,
    var value: MutableList<String>,
    var prefer: MutableList<String>
)

class ExamType {
    fun getTypeDetail(type: EnumExamType): ExamTypeDetail {
        return when (type) {
            EnumExamType.R -> this.R
            EnumExamType.I -> this.I
            EnumExamType.A -> this.A
            EnumExamType.S -> this.S
            EnumExamType.E -> this.E
            EnumExamType.C -> this.C
        }
    }

    private var R = ExamTypeDetail(
        job = mutableListOf("농업종사자", "경찰관", "소방수", "기술자", "목수", "운동선수"),
        feature = mutableListOf("실제적이며 단순함", "여러 사람들과 함께 일하는 것보다 혼자 일하는 것을 선호"),
        value = mutableListOf("전통적 가치", "독립적인 가치", "폐쇄적 신념"),
        prefer = mutableListOf("기계나 도구, 사물을 조작하는 활동", "사람이나 아이디어를 다루는 말보다는 사물을 다루는 일 선호")
    )

    private var I = ExamTypeDetail(
        mutableListOf("물리학자", "의학자", "수학자", "컴퓨터 프로그래머"),
        mutableListOf("지적이고 분석적임", "호기심 많고 개방적임"),
        mutableListOf("과학/학문적 성취", "개방된 신념"),
        mutableListOf("과학적이고 학문적인 활동", "문제해결을 위해 아이디어를 사용하고 정보를 분석하는 일 선호"),
    )

    private var A = ExamTypeDetail(
        mutableListOf("예술가", "작가", "음악가", "화가", "디자이너"),
        mutableListOf("상상력이 풍부하고 직관적임", "개방적이며 독창적임"),
        mutableListOf("심리적 경험 및 성취", "개방적 신념 체계", "자유목표의 가치"),
        mutableListOf("재능을 가지고 창의적인 작업을 수행하는 활동 선호"),
    )

    private var S = ExamTypeDetail(
        mutableListOf("교수", "상담가", "사회복지사", "성직자"),
        mutableListOf("명량하고 사교적임", "친절하고 이해심이 있음"),
        mutableListOf("사회, 윤리적 활동", "다른 사람을 도와주고자 하는 희망"),
        mutableListOf("개인적인 교류를 통해서 타인을 도와주고 가르치고 상담해주고 봉사하는 활동 선호"),
    )

    private var E = ExamTypeDetail(
        mutableListOf("경영인", "관리자", "언론인", "판매인"),
        mutableListOf("권력 지향적이며 지배적임", "야심이 많고 외향적임"),
        mutableListOf("경제적, 정치적 성취", "리더가 되고자 함", "야망에 가치"),
        mutableListOf("타인을 설득하고 지시하며 관리하는 활동 선호"),
    )

    private var C = ExamTypeDetail(
        mutableListOf("사무직 종사자", "사서", "비서"),
        mutableListOf("보수적이고 실용적임", "변화를 싫어하고 안정 추구"),
        mutableListOf("사무경제적 성취", "조직이나 제도의 내에서 일하는 것 선호"),
        mutableListOf("고정된 기준 내에서 일하고 관례를 정하고 유지하는 활동 선호"),
    )
}