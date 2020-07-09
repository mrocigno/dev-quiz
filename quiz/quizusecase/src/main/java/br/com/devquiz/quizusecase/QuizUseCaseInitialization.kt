package br.com.devquiz.quizusecase

import br.com.devquiz.commons.di.Initialization
import br.com.devquiz.quizusecase.usecase.QuizUseCase
import org.koin.core.module.Module
import org.koin.dsl.module

class QuizUseCaseInitialization : Initialization() {

    override fun init(): List<Module> = listOf(
        module {
            single { QuizUseCase(get()) }
        }
    )

}