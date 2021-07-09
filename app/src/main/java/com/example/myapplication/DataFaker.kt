package com.example.myapplication

import com.example.myapplication.models.AreaDefinitions
import com.example.myapplication.models.GameDefinition

object DataFaker {
    val gameDefinitions : ArrayList<GameDefinition> = ArrayList()

    init {
        populateGameDefinitions()
    }


    // dummy function for loading the class for first time
    fun populate(){
    }


    private fun populateGameDefinitions() {
        // populate game definitions
        val jokerAreaDefs = ArrayList<AreaDefinitions>()
        jokerAreaDefs.add(AreaDefinitions(2, 45))
        jokerAreaDefs.add(AreaDefinitions(1, 20))
        gameDefinitions.add(GameDefinition(5000, "Joker", "Tzoker", jokerAreaDefs))
        val loto = ArrayList<AreaDefinitions>()
        loto.add(AreaDefinitions(6, 49))
        gameDefinitions.add(GameDefinition(5001, "Lotto", "Lotto", loto))
    }
}

//Tzoker Game - GameDefinition
//m_GameCode=5000;
//m_Name= ”Tzoker”;
//and contains 2 area definitions in the m_AreaDefsArray
//One with
//m_NumbersToSelect=5; m_MaxNumbers=45;
//And one with
//m_NumbersToSelect=1; m_MaxNumbers=20;
//Lotto Game – Game Definition
//m_GameCode=5001;
//m_Name=”Lotto”;
//and contains 1 area definition in the m_AreaDefsArray
//With
//m_NumbersToSelect=6; m_MaxNumbers=49;
//When the user presses one of the table rows, the application should navigate to the 3rd screen.
