package br.com.devquiz.View

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.graphics.alpha
import java.lang.Exception
import kotlin.concurrent.timer
import kotlin.math.log
import kotlin.random.Random

class CanvasView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attributeSet, defStyleAttr) {

    private val low = Paint().apply {
        color = Color.argb(150,255, 255, 255)
    }

    private val medium = Paint().apply {
        color = Color.argb(200,255, 255, 255)
    }

    private val high = Paint().apply {
        color = Color.rgb(255, 255, 255)
    }

    private val stars = mutableListOf<Star>()
    private var width: Float = 10f
    private var height: Float = 10f
    private var close = false
    private var fps = 0

    private val engine = Thread(
        Runnable {
            Log.d("Engine", "started")
            val random = Random(100)
            while(true) {
                if (!Thread.currentThread().isInterrupted) Thread.sleep(10)
                else break
                if (close) Thread.currentThread().interrupt()

                if (fps++ % 5 == 0) {
                    stars.removeIf { it.x < 0 }
                    val rand = random.nextInt(3,8).toFloat()
                    stars.add(Star(
                        size = rand,
                        x = width,
                        y = random.nextInt(height.toInt()).toFloat(),
                        speed = rand,
                        paint = when {
                            rand.toInt() in (3..4) -> low
                            rand.toInt() in (5..6) -> medium
                            else -> high
                        }
                    ))
                }

                stars.forEach {
                    it.x = it.x - it.speed
                }
                invalidate()
            }
            Log.d("Engine", "closed")
        }
    )

    private val timer = timer(
        period = 1000,
        action = {
            Log.d("FPS", "fps: $fps - stars: ${stars.size}")
            fps = 0
        }
    )

    init {
        engine.start()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        width = MeasureSpec.getSize(widthMeasureSpec).toFloat()
        height = MeasureSpec.getSize(heightMeasureSpec).toFloat()

        invalidate()
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        try {
            canvas?.apply {
                stars.forEach { it.draw(canvas) }
            }
        } catch (e: Exception) { }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        close = true
        timer.cancel()
    }

}

class Star(
    var x: Float = 0f,
    var y: Float = 0f,
    var size: Float,
    var speed: Float,
    var paint: Paint
) {

    fun draw(canvas: Canvas) {
        canvas.drawCircle( x, y, size, paint)
    }

}