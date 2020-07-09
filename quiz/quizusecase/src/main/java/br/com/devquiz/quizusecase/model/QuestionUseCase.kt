package br.com.devquiz.quizusecase.model

import br.com.devquiz.quizrepository.model.AnswerResponse
import br.com.devquiz.quizrepository.model.QuestionResponse

class QuestionUseCase(
    val id: Int,
    val title: String,
    val question: String,
    val answers: List<AnswerUseCase>
)

class AnswerUseCase(
    val answer: String,
    val correct: Boolean
)

fun QuestionResponse.toUseCaseModel() = QuestionUseCase(
    id = id,
    title = title,
    question = question,
    answers = answers.map { it.toUseCaseModel() }
)

fun AnswerResponse.toUseCaseModel() = AnswerUseCase(
    answer = answer,
    correct = correct
)