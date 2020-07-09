package br.com.devquiz.quizviewmodel

import br.com.devquiz.commons.di.Initialization
import br.com.devquiz.quizviewmodel.viewmodel.QuizViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

class ViewModelInitialization : Initialization() {

    override fun init(): List<Module> = listOf(module {
        viewModel { QuizViewModel(get()) }
    })

}