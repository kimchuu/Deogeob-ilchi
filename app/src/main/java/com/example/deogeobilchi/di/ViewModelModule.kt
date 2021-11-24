package com.example.deogeobilchi.di

import org.koin.androidx.viewmodel.dsl.viewModel
import com.example.deogeobilchi.ui.exam.ExamViewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ExamViewModel()
    }
}