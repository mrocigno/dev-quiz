package br.com.devquiz.quizui.di

import br.com.devquiz.quizviewmodel.di.quizViewModelModule
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val quizUiModule = module {
    loadKoinModules(quizViewModelModule)
}