package br.com.devquiz.quizviewmodel.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.devquiz.commons.di.base.BaseViewModel
import br.com.devquiz.quizusecase.usecase.QuizUseCase
import br.com.devquiz.quizviewmodel.model.QuestionUI
import br.com.devquiz.quizviewmodel.model.toUIModel

class QuizViewModel(
    private val useCase: QuizUseCase
): BaseViewModel() {

    private val _questions = MutableLiveData<List<QuestionUI>>()
    val questions: LiveData<List<QuestionUI>> get() = _questions

    fun getQuestions() = launchData {
        _questions.value = useCase.getQuestions().map {
            it.toUIModel()
        }
    }

}