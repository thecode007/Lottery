package com.example.myapplication.ui.third

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.myapplication.R
import com.example.myapplication.Utils
import com.example.myapplication.models.GameDefinition
import com.example.myapplication.ui.fourth.FourthActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_third.*

class ThirdActivity : AppCompatActivity() {

    private val viewModel : ThirdViewModel by viewModels()

    companion object {
        val GAME_DEFINITION = "GAME_DEFINITION"

        fun launch(context: Context, gameDefinition: GameDefinition) {
            val  intent = Intent(context, ThirdActivity::class.java)
            intent.putExtra(GAME_DEFINITION, Gson().toJson(gameDefinition))
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        viewModel.gameDefinitionLD.observe(this, Observer {
            tv_game_title.text = it.m_N_Name
        })
        viewModel.numberOfTickets.observe(this, Observer {
            btn_tickets.text = getString(R.string.number_of_tickets)
                .plus(" ")
                .plus(it.toString())
        })
        viewModel.getDataFromIntent(this, intent)
        btn_tickets.setOnClickListener{
            NumberPickerDialogFragment().show(supportFragmentManager, "DIALOG")
        }
        viewModel.ticketsLD.observe(this, Observer {
            FourthActivity.launch(this, viewModel.ticketsLD.value!!)
        })


        btn_generate.setOnClickListener{
           viewModel.generateTickets()
        }
    }


}