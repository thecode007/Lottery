package com.example.myapplication.ui.pickeRandom

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.RowGameDefinitionBinding
import com.example.myapplication.models.GameDefinition

class PickRandomAdapter(val activity: Activity) : RecyclerView.Adapter<PickRandomViewHolder>() {

    private val gameDefinitions:ArrayList<GameDefinition> = ArrayList()


    fun setData(definitions:ArrayList<GameDefinition> ) {
        gameDefinitions.clear()
        gameDefinitions.addAll(definitions)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PickRandomViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RowGameDefinitionBinding.inflate(layoutInflater, parent, false)
        return  PickRandomViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PickRandomViewHolder, position: Int) {
        holder.bind(gameDefinitions[position])
    }

    override fun getItemCount(): Int {
        return gameDefinitions.size
    }

}