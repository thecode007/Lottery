package com.example.myapplication.ui.fourth


import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Utils
import com.example.myapplication.databinding.RowGameDefinitionBinding
import com.example.myapplication.databinding.RowTicketBinding
import com.example.myapplication.models.GameDefinition
import com.example.myapplication.models.Ticket
import com.example.myapplication.ui.third.ThirdActivity
import com.google.gson.Gson


class FourthViewHolder(private val binding: RowTicketBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(ticket: Ticket, onTicketClickListener: FourthAdapter.OnTicketClickListener?) {
        binding.viewModel = ticket.toString()
        binding.root.setOnClickListener {
            onTicketClickListener?.onTicketClicked(ticket)
        }
    }
}