package com.example.deogeobilchi.data.work

import com.example.deogeobilchi.data.Repository
import com.example.deogeobilchi.model.WorkModel
import kotlinx.coroutines.flow.Flow

class WorkRepositoryImpl(private val workDao: WorkDao): Repository<WorkModel> {
    override fun getAllData(): Flow<MutableList<WorkModel>> = workDao.getAllData()

    override suspend fun insert(data: WorkModel) = workDao.insert(data)

    override suspend fun update(data: WorkModel) = workDao.update(data)

    override suspend fun delete(data: WorkModel) = workDao.delete(data)
}