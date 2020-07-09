package br.com.devquiz.quizviewmodel.model

import br.com.devquiz.quizusecase.model.AnswerUseCase
import br.com.devquiz.quizusecase.model.QuestionUseCase

class QuestionUI(
    val id: Int,
    val title: String,
    val question: String,
    val answers: List<AnswerUI>
)

class AnswerUI(
    val answer: String,
    val correct: Boolean
)

fun QuestionUseCase.toUIModel() = QuestionUI(
    id = id,
    title = title,
    question = question,
    answers = answers.map { it.toUIModel() }
)

fun AnswerUseCase.toUIModel() = AnswerUI(
    answer = answer,
    correct = correct
)