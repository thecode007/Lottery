package com.example.myapplication.models

data class GameDefinition(
    val m_GameCode : Int,
    val m_NameEn:String,
    val m_N_ameGr: String,
    val m_AreaDefsArray : ArrayList<AreaDefinitions>,
    var m_N_Name :String = ""
)