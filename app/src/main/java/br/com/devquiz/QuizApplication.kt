package br.com.devquiz

import android.app.Application
import br.com.devquiz.di.initializationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class QuizApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidContext(this@QuizApplication)

            modules(initializationModule)
        }
    }

}