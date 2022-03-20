package com.example.interapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.interapp.dtos.*
import com.example.interapp.logic.ItemAdapter
import com.example.interapp.logic.JSONProvider

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val infoDto = JSONProvider().getAccountData(applicationContext, "AccountDto.json")
        val content = createContent(infoDto)
        val recyclerView = findViewById<RecyclerView>(R.id.list)
        val adapter = ItemAdapter()
        adapter.submitList(content)
        recyclerView.addItemDecoration(
            RecyclerListDecorator(content, ResourcesCompat.getDrawable(resources, R.drawable.divider,null)!!)
        )
        recyclerView.adapter = adapter
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun createContent(infoDto: AccountInfo) : List<Item>{
        val map = createMap()
        val content: ArrayList<Item> = ArrayList()
        content.add(Title("Личный кабинет",12))
        content.add(infoDto.info)
        content.add(Title("Тариф",12))
        content.addAll(infoDto.availableTariffs)
        content.add(Title("Пользователь",12))
        for (info in infoDto.userInfo) {
            content.add(User(info.text,null,
                map[info.iconName]?.let { applicationContext.getDrawable(it) }))
        }
        return content
    }

    private fun createMap(): HashMap<String, Int>{
        val map : HashMap<String, Int> = HashMap()
        map["account"] = R.drawable.ic_baseline_account_circle_24
        map["home"] = R.drawable.ic_baseline_home_24
        map["widgets"] = R.drawable.ic_baseline_widgets_24
        return map
    }
}





