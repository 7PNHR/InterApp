package com.example.interapp.logic

import android.content.Context
import com.example.interapp.data.AccountInfo
import com.google.gson.Gson

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