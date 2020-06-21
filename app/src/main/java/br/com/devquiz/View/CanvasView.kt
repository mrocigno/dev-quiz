package br.com.devquiz.View

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import kotlin.concurrent.timer
import kotlin.random.Random

class CanvasView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    val paint = Paint().apply {
        color = Color.WHITE
    }

    val stars = mutableListOf(
        Star(size = 1f),
        Star(size = 2f),
        Star(size = 3f),
        Star(size = 4f),
        Star(size = 5f),
        Star(size = 6f),
        Star(size = 7f),
        Star(size = 8f),
        Star(size = 9f),
        Star(size = 10f)
    )

    init {
        var fps = 0
        Thread(Runnable {
            while(true) {
                fps++

                stars.forEach {
                    it.x = it.x - it.size
                }
                invalidate()

                Thread.sleep(10)
            }
        }).start()
        timer(
            period = 1000,
            action = {
                Log.d("FPS", "fps: $fps - stars: ${stars.size}")
                fps = 0
            }
        )
        val random = Random(100)
        timer(
            period = 100,
            action = {
                try {
                    stars.removeIf {
                        it.x < 0
                    }
                    stars.add(Star(
                        size = random.nextInt(10).toFloat(),
                        x = width,
                        y = random.nextInt(height.toInt()).toFloat()
                    ))
                } finally {

                }
            }
        )
    }


    var width: Float = 10f
    var height: Float = 10f

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        width = MeasureSpec.getSize(widthMeasureSpec).toFloat()
        height = MeasureSpec.getSize(heightMeasureSpec).toFloat()

        val random = Random(heightMeasureSpec)
        stars.forEach {


            it.x = width
            it.y = random.nextInt(height.toInt()).toFloat()

            Log.d("TESTE", "x: ${it.x} - y: ${it.y}")
        }

        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        try {
            canvas?.apply {
                stars.forEach {
                    drawCircle( it.x, it.y, it.size, paint)
                }
            }
        } catch (e: Exception) {

        }
    }

}

class Star(
    var x: Float = 0f,
    var y: Float = 0f,
    var size: Float = 3f
) {



}