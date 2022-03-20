package com.example.interapp.logic

import android.content.Context
import com.example.interapp.dtos.AccountInfo
import com.google.gson.Gson
import java.io.IOException

class JSONProvider {
    fun getAccountData(context: Context, name: String): AccountInfo {
        val gson = Gson()
        val jsonString: String = context
                .assets
                .open(name)
                .bufferedReader()
                .use { it.readText() }
        return gson.fromJson(jsonString, AccountInfo::class.java)
    }
}