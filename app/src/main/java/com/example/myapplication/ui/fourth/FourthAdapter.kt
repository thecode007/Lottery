package com.example.myapplication.ui.fourth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RowTicketBinding
import com.example.myapplication.models.Ticket

class FourthAdapter : RecyclerView.Adapter<FourthViewHolder>()  {

    private val tickets:ArrayList<Ticket> = ArrayList()


    fun setData(ticket:ArrayList<Ticket> ) {
        tickets.clear()
        tickets.addAll(ticket)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FourthViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowTicketBinding.inflate(layoutInflater, parent, false)
        return  FourthViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FourthViewHolder, position: Int) {
        holder.bind(tickets[position])
    }

    override fun getItemCount(): Int {
        return tickets.size
    }
}