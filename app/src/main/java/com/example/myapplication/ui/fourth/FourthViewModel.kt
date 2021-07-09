package com.example.myapplication.ui.fourth

import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.models.Ticket
import com.example.myapplication.ui.fourth.FourthActivity.Companion.N_O_F
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.*


class FourthViewModel: ViewModel() {

    val ticketsLD = MutableLiveData<ArrayList<Ticket>>()
    val dislpayTextLD = MutableLiveData<String>()

    fun getDataFromIntent(intent: Intent) {
        if (intent.hasExtra(N_O_F)) {
            val tikettype = object : TypeToken<ArrayList<Ticket>>() {}.type
            val tickets = Gson().fromJson<ArrayList<Ticket>>(intent.getStringExtra(N_O_F), tikettype)
            ticketsLD.value = tickets
        }
    }

    suspend fun calculate(ticket: Ticket){
        GlobalScope.launch(Dispatchers.Main) {
            val oddCount = withContext(Dispatchers.IO) { calculateOdd(ticket) }
            val evenCount = withContext(Dispatchers.IO) { calculateEven(ticket) }
            val  sum = withContext(Dispatchers.IO) { calculateSum(ticket) }

            dislpayTextLD.value = sum.toString()
                .plus(":")
                .plus(oddCount)
                .plus(":")
                .plus(evenCount)
                .plus(":")
        }
    }


    suspend fun calculateOdd(ticket: Ticket): Int{
        return GlobalScope.async(Dispatchers.Main) {
            val numbers = ticket.firstArray

            var oddCount = 0
            for (number in numbers) {
                if (number % 2 != 0){
                    oddCount ++
                }
            }
            if (ticket.secondChoice > 0) {
                if (ticket.secondChoice % 2 !=0) {
                    oddCount ++
                }
            }
            return@async oddCount
        }.await()
    }

    suspend fun calculateEven(ticket: Ticket): Int{
        return GlobalScope.async(Dispatchers.Main) {
            val numbers = ticket.firstArray
            var evenCount = 0
            for (number in numbers) {
                if (number % 2 == 0){
                    evenCount ++
                }
            }
            if (ticket.secondChoice > 0) {
                if (ticket.secondChoice % 2 ==0) {
                    evenCount ++
                }
            }
            return@async evenCount
        }.await()
    }


    suspend fun calculateSum(ticket: Ticket): Int{
        return GlobalScope.async(Dispatchers.IO) {
            val numbers = ticket.firstArray
            var sum = 0
            for (number in numbers) {
                sum += number
            }
            if (ticket.secondChoice > 0) {
                sum += ticket.secondChoice
            }
            return@async sum
        }.await()
    }

}