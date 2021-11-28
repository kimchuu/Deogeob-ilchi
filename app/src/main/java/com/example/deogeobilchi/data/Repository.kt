package com.example.deogeobilchi.data

import kotlinx.coroutines.flow.Flow

interface Repository<T> {
    fun getAllData(): Flow<MutableList<T>>
    suspend fun insert(data: T)
    suspend fun update(data: T)
    suspend fun delete(data: T)
}