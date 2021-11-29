package com.example.deogeobilchi.di

import com.example.deogeobilchi.ui.detail.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import com.example.deogeobilchi.ui.exam.ExamViewModel
import com.example.deogeobilchi.ui.main.MainViewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        ExamViewModel()
    }

    viewModel {
        MainViewModel(workRepository = get())
    }

    viewModel {
        DetailViewModel(workRepository = get())
    }
}