package com.example.deogeobilchi.di

import com.example.deogeobilchi.data.work.WorkDB
import com.example.deogeobilchi.data.work.WorkRepositoryImpl
import org.koin.dsl.module

val roomModule = module{
    single<WorkRepositoryImpl> { WorkRepositoryImpl(WorkDB.Factory.create(get()).getDao()) }
}