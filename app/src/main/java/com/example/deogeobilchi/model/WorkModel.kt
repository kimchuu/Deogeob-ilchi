package com.example.deogeobilchi.model

import androidx.room.*
import java.io.Serializable

@Entity(tableName = "WorkModel")
data class WorkModel(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "company") var company: String,
    @ColumnInfo(name = "work") var work: String,
    @ColumnInfo(name = "type") var type: EnumExamType, // 후에 MutableList<EnumExamType>으로 변경 -> type converter error
    @ColumnInfo(name = "image") var image: Int,
    @ColumnInfo(name = "star") var star: Int = 5,
    @ColumnInfo(name = "isLike") var isLike: Boolean = false,
    @ColumnInfo(name = "isApply") var isApply: Boolean = false
):Serializable