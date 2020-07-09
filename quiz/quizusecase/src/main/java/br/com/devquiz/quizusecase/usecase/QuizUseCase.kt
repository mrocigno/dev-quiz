package br.com.devquiz.quizusecase.usecase

import br.com.devquiz.quizrepository.repository.QuestionsRepository
import br.com.devquiz.quizusecase.model.toUseCaseModel

class QuizUseCase(
    private val questionRepository: QuestionsRepository
) {

    suspend fun getQuestions() = questionRepository.loadQuestions().map {
        it.toUseCaseModel()
    }

}