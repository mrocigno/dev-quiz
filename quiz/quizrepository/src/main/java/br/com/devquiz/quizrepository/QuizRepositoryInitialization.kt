package br.com.devquiz.quizrepository

import br.com.devquiz.commons.di.Initialization
import br.com.devquiz.quizrepository.repository.QuestionsRepository
import org.koin.core.module.Module
import org.koin.dsl.module

class QuizRepositoryInitialization : Initialization() {

    override fun init(): List<Module> = listOf(
        module {
            single { QuestionsRepository() }
        }
    )
}