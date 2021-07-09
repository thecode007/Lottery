package com.example.myapplication.ui.third

import android.content.Context
import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.Utils
import com.example.myapplication.models.GameDefinition
import com.example.myapplication.models.Ticket
import com.example.myapplication.ui.third.ThirdActivity.Companion.GAME_DEFINITION
import com.google.gson.Gson

class ThirdViewModel: ViewModel() {

    val gameDefinitionLD: MutableLiveData<GameDefinition> = MutableLiveData()
    var numberOfTickets : MutableLiveData<Int> = MutableLiveData(1)
    var ticketsLD : MutableLiveData<ArrayList<Ticket>> = MutableLiveData()

    fun getDataFromIntent(context: Context, intent:Intent) {
        if (intent.hasExtra(GAME_DEFINITION)) {
            val gameDefinition = Gson().fromJson(intent.getStringExtra(GAME_DEFINITION),
                GameDefinition::class.java)
            correctNameBasedOnLanguage(context, gameDefinition)
            gameDefinitionLD.value = gameDefinition
        }
    }

    private fun correctNameBasedOnLanguage(context: Context, gameDefinition: GameDefinition) {
        if (Utils.isGreek(context)) {
            gameDefinition.m_N_Name = gameDefinition.m_N_ameGr
        }
        else {
            gameDefinition.m_N_Name = gameDefinition.m_NameEn
        }
    }

    fun generateTickets() {

        val definition = gameDefinitionLD.value!!.m_AreaDefsArray
        val firstRandomList = ArrayList((definition[0].m_NumbersToSelect..definition[0].m_MaxNumbers).shuffled())
        val datas = ArrayList<Ticket>()
        if (definition.size > 1) {
            val secondList = ArrayList((definition[1].m_NumbersToSelect..definition[1].m_MaxNumbers).shuffled())
            for (i in 0 until numberOfTickets.value!!) {
                val batch = firstRandomList.take(5)
                val secondBatch = secondList.take(1)
                firstRandomList.removeAll(batch)
                secondList.removeAll(secondBatch)
                datas.add(Ticket(i + 1,batch, secondBatch[0]))
            }
        }
        else {
            for (i in 0 until numberOfTickets.value!!) {
                datas.add(Ticket(i + 1,firstRandomList.take(5)))
            }
        }
        ticketsLD.value = datas

    }
}