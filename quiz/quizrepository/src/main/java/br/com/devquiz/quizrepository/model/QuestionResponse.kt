package br.com.devquiz.quizrepository.model

class QuestionResponse(
    val id: Int,
    val title: String,
    val question: String,
    val answers: List<AnswerResponse>
)

class AnswerResponse(
    val answer: String,
    val correct: Boolean
)