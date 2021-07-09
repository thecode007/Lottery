package com.example.myapplication.ui.fourth

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.models.Ticket
import com.example.myapplication.ui.fourth.FourthActivity.Companion.N_O_F
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class FourthViewModel: ViewModel() {

    val ticketsLD = MutableLiveData<ArrayList<Ticket>>()

    fun getDataFromIntent(intent: Intent) {
        if (intent.hasExtra(N_O_F)) {
            val tikettype = object : TypeToken<ArrayList<Ticket>>() {}.type
            val tickets = Gson().fromJson<ArrayList<Ticket>>(intent.getStringExtra(N_O_F), tikettype)
            ticketsLD.value = tickets
        }
    }

}