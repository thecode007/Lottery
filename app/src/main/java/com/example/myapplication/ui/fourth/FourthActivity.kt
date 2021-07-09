package com.example.myapplication.ui.fourth

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.models.Ticket
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_fourth.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FourthActivity : AppCompatActivity(), FourthAdapter.OnTicketClickListener {
    private val viewModel : FourthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fourth)

        viewModel.ticketsLD.observe(this, {
            val adapter = FourthAdapter()
            adapter.onTicketClickListener = this
            adapter.setData(it)
            rv_tickets.layoutManager = LinearLayoutManager(this)
            adapter.setData(it)
            rv_tickets.adapter = adapter
        })
        viewModel.getDataFromIntent(intent)
        viewModel.dislpayTextLD.observe(this, Observer {
            MaterialAlertDialogBuilder(this)
                .setMessage(it)
                .show()
        })

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

    override fun onTicketClicked(ticket: Ticket) {
        GlobalScope.launch(Dispatchers.Main) {
            viewModel.calculate(ticket)
        }
    }
}