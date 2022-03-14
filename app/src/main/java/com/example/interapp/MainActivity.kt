package com.example.interapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.interapp.logic.JSONInfoProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val infoDto = JSONInfoProvider().getAccountData(applicationContext)

    }
}

