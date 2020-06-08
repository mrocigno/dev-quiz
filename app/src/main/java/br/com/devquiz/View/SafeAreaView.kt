package br.com.devquiz.View

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout

class SafeAreaView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        setPadding(
            leftPaddingOffset,
            topPaddingOffset + context.getStatusBarHeight(),
            rightPaddingOffset,
            bottomPaddingOffset + context.getNavigationBarHeight()
        )
    }
}


fun Context.getNavigationBarHeight() : Int {
    val resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
    if (resourceId > 0) {
        return resources.getDimensionPixelSize(resourceId)
    }
    return 0
}

fun Context.getStatusBarHeight() : Int {
    val resourceId = resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
        return resources.getDimensionPixelSize(resourceId)
    }
    return 0
}