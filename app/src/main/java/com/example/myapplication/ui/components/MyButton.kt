package com.example.myapplication.ui.components


import android.content.Context
import android.graphics.drawable.StateListDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.myapplication.R


class MyButton : AppCompatButton{
    constructor(context: Context,  buttonTextRes:Int) : super(context) {
        text = context.getString(buttonTextRes)
    }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        setTextColor(ContextCompat.getColor(context, R.color.white))
        setPadding(10, 15,10, 15)
        attachSelector(R.drawable.button_blue_pressed, R.drawable.button_blue)
    }


    private fun attachSelector(pressedStateImageRes: Int, normalStateImageRes: Int) {
        val states = StateListDrawable()
        states.addState(
            intArrayOf(android.R.attr.state_pressed),
            ContextCompat.getDrawable(context, pressedStateImageRes),

        )
        states.addState(
            intArrayOf(),
            ContextCompat.getDrawable(context, normalStateImageRes)
        )
        states.mutate()
        background = states
    }
}