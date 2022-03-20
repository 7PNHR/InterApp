package com.example.interapp.dtos

data class AccountInfo(
    val info: Info,
    val availableTariffs: List<Tariff>,
    val userInfo:List<UserInfo> )
