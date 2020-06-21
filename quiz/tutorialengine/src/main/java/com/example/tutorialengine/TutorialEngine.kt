package com.example.tutorialengine

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.Paint.ANTI_ALIAS_FLAG
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.tutorial_layout.view.*



class TutorialEngine @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
): FrameLayout(context, attrs, defStyle) {

    private var bodyWidth = 0
    private var bodyHeight = 0
    private var viewsHighlighted: List<View>? = null

    init {
        setWillNotDraw(false)
        setLayerType(View.LAYER_TYPE_HARDWARE, null)
        background = context.getDrawable(R.drawable.tutorial_background)
        elevation = 10f
        layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        inflate(context, R.layout.tutorial_layout, this)

        ObjectAnimator.ofFloat(this, "alpha", 0f, 1f).apply {
            duration = 300
        }.start()
    }

    private val transitionAnimator = ObjectAnimator.ofFloat(0f, 1f).apply {
        duration = 300
        addUpdateListener { invalidate() }
    }

    fun handleStep(tutorialStep: TutorialStep) {
        tutorialStep.let {
            title.text = it.title
            helpText.text = it.helpText
            viewsHighlighted = it.views
            transitionAnimator.start()
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        bodyWidth = MeasureSpec.getSize(widthMeasureSpec)
        bodyHeight = MeasureSpec.getSize(heightMeasureSpec)
    }

    private var highlightPaint = Paint(ANTI_ALIAS_FLAG).apply {
        xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }

    var oldX1 = 0f
    var oldX2 = 0f
    var oldY1 = 0f
    var oldY2 = 0f

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val animatedValue = (transitionAnimator.animatedValue as Float)
        viewsHighlighted?.forEach {
            val calcX1 = (it.x - oldX1) * animatedValue
            val calcX2 = ((it.x + it.width) - oldX2) * animatedValue
            val calcY1 = (it.y - oldY1) * animatedValue
            val calcY2 = ((it.y + it.height) - oldY2) * animatedValue
            canvas?.drawRoundRect(
                (oldX1 + calcX1) - 10f,
                (oldY1 + calcY1) - 10f,
                (oldX2 + calcX2 + 10f),
                (oldY2 + calcY2 + 10f),
                10f,
                10f,
                highlightPaint
            )
        }
    }

}

class TutorialStep(
    val title: String = "",
    val helpText: String = "",
    val views: List<View>,
    val nextAction: ((index: Int) -> Unit)? = null,
    val prevAction: ((index: Int) -> Unit)? = null
)