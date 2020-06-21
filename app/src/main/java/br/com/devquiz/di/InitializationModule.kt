package br.com.devquiz.di

import br.com.devquiz.quizui.di.quizUiModule
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val initializationModule = module {
    loadKoinModules(
        quizUiModule
    )
}