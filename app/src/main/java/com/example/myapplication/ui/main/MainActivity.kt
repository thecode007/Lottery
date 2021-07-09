package com.example.myapplication.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.ui.pickeRandom.PickRandomNumberActivity

class MainActivity : AppCompatActivity(), MainMenuLayout.OnMainButtonsClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mainMenuLayout = MainMenuLayout(this)
        mainMenuLayout.onMainButtonClickListener = this
        setContentView(mainMenuLayout)
    }

    override fun onFirstButtonClicked() {
        startActivity(Intent(this, PickRandomNumberActivity::class.java))
    }

    override fun onSecondButtonClicked() {

    }
}