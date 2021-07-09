package com.example.myapplication.ui.pickeRandom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.DataFaker
import com.example.myapplication.R
import com.example.myapplication.models.GameDefinition
import kotlinx.android.synthetic.main.activity_pickrandom_number.*

class PickRandomNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pickrandom_number)
        rv_definitions.layoutManager = LinearLayoutManager(this)

        val adapter = PickRandomAdapter(this)
        rv_definitions.adapter = adapter
        adapter.setData(DataFaker.gameDefinitions)
    }
}