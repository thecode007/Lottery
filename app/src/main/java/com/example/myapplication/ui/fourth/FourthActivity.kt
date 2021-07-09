package com.example.myapplication.ui.fourth

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.models.GameDefinition
import com.example.myapplication.models.Ticket
import com.example.myapplication.ui.third.ThirdActivity.Companion.GAME_DEFINITION
import com.example.myapplication.ui.third.ThirdViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_fourth.*
import kotlin.time.measureTimedValue

class FourthActivity : AppCompatActivity() {
    private val viewModel : FourthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        viewModel.ticketsLD.observe(this, {
            val adapter = FourthAdapter()
            adapter.setData(it)
            rv_tickets.layoutManager = LinearLayoutManager(this)
            adapter.setData(it)
            rv_tickets.adapter = adapter
        })
        viewModel.getDataFromIntent(intent)

    }

    companion object {
        val N_O_F :String = "NUMBER_OF_TICKETS"

        fun launch(context: Context, ticket: ArrayList<Ticket>) {
            val intent = Intent(context, FourthActivity::class.java)
            intent.putExtra(N_O_F, Gson().toJson(ticket))
//            intent.putExtra(GAME_DEFINITION, Gson().toJson(gameDefinition))
            context.startActivity(intent)
        }
    }
}