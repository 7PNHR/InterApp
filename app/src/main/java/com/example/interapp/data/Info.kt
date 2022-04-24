package com.example.interapp.data

data class Info(
    val month: String = "Сентябрь",
    val accNum: Int,
    val balance: Int,
    val nextPay: Int,
    val id: String) : Item()