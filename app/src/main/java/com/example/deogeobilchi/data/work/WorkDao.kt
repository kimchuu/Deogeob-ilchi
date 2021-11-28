package com.example.deogeobilchi.data.work

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import com.example.deogeobilchi.model.WorkModel
import kotlinx.coroutines.flow.Flow


@Dao
interface WorkDao {
    @Query("SELECT * FROM WorkModel")
    fun getAllData(): Flow<MutableList<WorkModel>>

    @Insert(onConflict = REPLACE)
    suspend fun insert(workModel: WorkModel)

    @Delete
    suspend fun delete(workModel: WorkModel)

    @Update
    suspend fun update(workModel: WorkModel)
}