package com.example.deogeobilchi.model

import androidx.room.*


@Entity
data class WorkModel(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id") val id: Long,
    @ColumnInfo(name="company") var company : String,
    @ColumnInfo(name="work") var work: String,
    @ColumnInfo(name="type") var type: String, // 후에 MutableList<String>으로 변경 -> type converter error
    @ColumnInfo(name="image") var image: Int,
    @ColumnInfo(name="star") var star: Int,
    @ColumnInfo(name="isLike") var isLike: Boolean
)
