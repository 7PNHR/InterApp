package com.example.interapp.dtos

data class AccountInfoDto(
    val month: String,
    val ls: String,
    val balance: String,
    val dept: String,
    val availableTariffs: List<AccountTariff>,
    val userInfo:List<String> )
