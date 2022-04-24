package com.example.interapp.data

import android.graphics.drawable.Drawable

data class User(
    val text: String,
    val iconName: String?,
    val drawable : Drawable?) : Item()

/*
*
    {
      "text": "Иванов Иван Иванович",
      "iconName": "account"
    },
    {
      "text": "Сахалин, ул. Пушкина, д. Колотушкина",
      "iconName": "home"
    },
 */