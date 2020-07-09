package br.com.devquiz.quizui

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import br.com.devquiz.commons.di.extensions.observe
import br.com.devquiz.quizviewmodel.viewmodel.QuizViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val quizViewModel: QuizViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        setupObservables()
    }

    private fun setupObservables() {
        observe(quizViewModel.questions) {

        }
    }

}
