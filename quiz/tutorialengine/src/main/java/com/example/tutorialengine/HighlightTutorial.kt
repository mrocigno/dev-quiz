package com.example.tutorialengine

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class HighlightTutorial private constructor(
    val list: List<TutorialStep>,
    isDismissible: Boolean,
    onChangeStep: (index: Int) -> Unit
) {

    var currentIndex = 0
    private lateinit var tutorialEngine: TutorialEngine

    fun start(context: Context, container: ViewGroup, initialStep: Int = 0) {
        currentIndex = initialStep
        tutorialEngine = TutorialEngine(context)
        container.addView(tutorialEngine)
        tutorialEngine.handleStep(list[currentIndex])
    }


    class Builder(builder: Builder.() -> Unit) {

        private val list = mutableListOf<TutorialStep>()
        var isDismissible: Boolean = false
        var onChangeStep: (index: Int) -> Unit = {}

        fun addStep(
            title: String,
            body: String,
            targets: List<View>
        ) {
            list.add(TutorialStep(
                title = title,
                helpText = body,
                views = targets
            ))
        }

        fun addStep(
            title: String,
            body: String,
            target: View
        ) = addStep(title, body, listOf(target))

        fun build(): HighlightTutorial = HighlightTutorial(list, isDismissible, onChangeStep)

    }

}