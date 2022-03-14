package com.example.interapp.logic

import android.content.Context
import com.example.interapp.dtos.AccountInfoDto
import com.google.gson.Gson
import java.io.IOException

class JSONInfoProvider {
    fun getAccountData(context: Context): AccountInfoDto? {
        val gson = Gson()
        val jsonString: String
        try {
            jsonString = context
                .assets
                .open("AccountDto.json")
                .bufferedReader()
                .use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return gson.fromJson(jsonString, AccountInfoDto::class.java)
    }
}