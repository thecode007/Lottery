package com.example.myapplication.ui.main

import android.content.Context
import android.graphics.drawable.ShapeDrawable
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import com.example.myapplication.ui.components.MyButton
import com.example.myapplication.R


class MainMenuLayout(context: Context?) : LinearLayout(context) {


    var onMainButtonClickListener : OnMainButtonsClickListener? = null

    init {
        orientation = VERTICAL
        gravity = Gravity.CENTER_HORIZONTAL
        initView()
    }
    private fun initView() {
        removeAllViews()
        val divider = ShapeDrawable()
        divider.intrinsicHeight = 50
        divider.alpha = 0
        dividerDrawable = divider
        showDividers = SHOW_DIVIDER_MIDDLE
        addView(buildTitleView(context.getString(R.string.lottery_random_number_generator)))
        val firstButton = MyButton(context, R.string.pick_random_numbers)
        firstButton.setOnClickListener{
            onMainButtonClickListener?.onFirstButtonClicked()
        }
        addView(firstButton)
        val secondButton = MyButton(context, R.string.cost_estimation)
        secondButton.setOnClickListener{
            onMainButtonClickListener?.onSecondButtonClicked()
        }
        addView(secondButton)
    }


    private fun buildTitleView(title:String):TextView {
        val titleTextView = TextView(context)
        titleTextView.text = title
        return titleTextView
    }



    interface OnMainButtonsClickListener{
        fun onFirstButtonClicked()
        fun onSecondButtonClicked()
    }


}