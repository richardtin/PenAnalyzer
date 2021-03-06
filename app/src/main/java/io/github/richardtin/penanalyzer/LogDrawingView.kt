package io.github.richardtin.penanalyzer

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.MotionEvent
import com.mukesh.DrawingView

class LogDrawingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : DrawingView(context, attrs, defStyleAttr) {

    var logger: InputEventLogger? = null

    override fun onDraw(canvas: Canvas?) {
        logger?.let { super.onDraw(canvas) }
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (logger != null) {
            event?.let {
                logger?.log("${it.x},${it.y},${it.touchMajor},${it.touchMinor},${it.size},${it.pressure},${it.eventTime},${it.downTime},${it.getToolType(0)}")
                return super.onTouchEvent(event)
            }
        }
        return true
    }
}