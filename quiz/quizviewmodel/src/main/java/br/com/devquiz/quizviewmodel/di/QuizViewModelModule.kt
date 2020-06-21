package br.com.devquiz.quizviewmodel.di

import br.com.devquiz.quizviewmodel.viewModel.QuizViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val quizViewModelModule = module {
    viewModel{ QuizViewModel() }
}