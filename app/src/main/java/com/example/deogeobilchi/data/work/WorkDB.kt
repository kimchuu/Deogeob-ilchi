package com.example.deogeobilchi.data.work

import android.content.Context
import androidx.room.*
import com.example.deogeobilchi.model.WorkModel

@Database(entities = [WorkModel::class], version = 1)
abstract class WorkDB : RoomDatabase() {
    abstract fun getDao(): WorkDao
    object Factory {
        private const val dbName = "work.db"
        fun create(context: Context): WorkDB {
            return Room.databaseBuilder(
                context.applicationContext,
                WorkDB::class.java,
                dbName
            ).build()
        }
    }
}