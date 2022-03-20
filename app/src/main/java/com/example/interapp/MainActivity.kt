package com.example.interapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.interapp.dtos.*
import com.example.interapp.logic.TariffAdapter
import com.example.interapp.logic.JSONProvider

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val infoDto = JSONProvider().getAccountData(applicationContext, "AccountDto.json")
        val recyclerView = findViewById<RecyclerView>(R.id.list)

        val adapter = TariffAdapter()
        adapter.submitList(infoDto.availableTariffs)
        recyclerView.addItemDecoration(
            RecyclerListDecorator(infoDto.availableTariffs, ResourcesCompat.getDrawable(resources, R.drawable.divider,null)!!)
        )
        recyclerView.adapter = adapter
    }

    private fun createMap(): HashMap<String, Int>{
        val map : HashMap<String, Int> = HashMap()
        map["account"] = R.drawable.ic_baseline_account_circle_24
        map["home"] = R.drawable.ic_baseline_home_24
        map["widgets"] = R.drawable.ic_baseline_widgets_24
        return map
    }
}





