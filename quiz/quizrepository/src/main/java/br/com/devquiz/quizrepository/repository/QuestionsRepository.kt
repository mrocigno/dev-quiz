package br.com.devquiz.quizrepository.repository

import br.com.devquiz.quizrepository.model.AnswerResponse
import br.com.devquiz.quizrepository.model.QuestionResponse
import kotlinx.coroutines.Job

class QuestionsRepository {

    suspend fun loadQuestions(): List<QuestionResponse> {
        return listOf(
            QuestionResponse(
                id = 1,
                title = "Teste 1",
                question = "Qual o nome desse app?",
                answers = listOf(
                    AnswerResponse(
                        answer = "DevQuiz",
                        correct = true
                    ),
                    AnswerResponse(
                        answer = "Perguntados",
                        correct = false
                    ),
                    AnswerResponse(
                        answer = "Show do milhão",
                        correct = false
                    ),
                    AnswerResponse(
                        answer = "Perguntas top",
                        correct = false
                    )
                )
            ),
            QuestionResponse(
                id = 2,
                title = "Teste 2",
                question = "Essa é uma boa pergunta?",
                answers = listOf(
                    AnswerResponse(
                        answer = "Sim",
                        correct = true
                    ),
                    AnswerResponse(
                        answer = "Não",
                        correct = false
                    ),
                    AnswerResponse(
                        answer = "Não",
                        correct = false
                    ),
                    AnswerResponse(
                        answer = "Não",
                        correct = false
                    )
                )
            ),
            QuestionResponse(
                id = 3,
                title = "Teste 3",
                question = "Não tenho mais criatividade",
                answers = listOf(
                    AnswerResponse(
                        answer = "Essa é a certa",
                        correct = true
                    ),
                    AnswerResponse(
                        answer = "Errada",
                        correct = false
                    ),
                    AnswerResponse(
                        answer = "Errada",
                        correct = false
                    ),
                    AnswerResponse(
                        answer = "Errada",
                        correct = false
                    )
                )
            )
        )
    }

}