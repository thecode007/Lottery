package com.example.myapplication.ui.pickeRandom


import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Utils
import com.example.myapplication.databinding.RowGameDefinitionBinding
import com.example.myapplication.models.GameDefinition
import com.example.myapplication.ui.third.ThirdActivity
import com.google.gson.Gson


class PickRandomViewHolder(private val binding: RowGameDefinitionBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(gameDefinition: GameDefinition) {
        setNameBasedOnLanguage(gameDefinition)
        binding.viewModel = gameDefinition
        binding.root.setOnClickListener{
            ThirdActivity.launch(it.context, gameDefinition)
        }
        binding.executePendingBindings()
    }

    private fun setNameBasedOnLanguage(gameDefinition: GameDefinition){
        if (Utils.isGreek(binding.root.context)) {
            gameDefinition.m_N_Name = gameDefinition.m_N_ameGr
        }
        else{
            gameDefinition.m_N_Name = gameDefinition.m_NameEn
        }
    }


}