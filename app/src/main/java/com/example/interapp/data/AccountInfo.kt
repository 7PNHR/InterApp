package com.example.interapp.data

data class AccountInfo(
    val info: Info,
    val availableTariffs: List<Tariff>,
    val userInfo:List<User> )
