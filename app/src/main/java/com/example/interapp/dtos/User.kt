package com.example.interapp.dtos

import android.graphics.drawable.Drawable

data class User(
    val text: String,
    val iconName: String?,
    val drawable : Drawable?) : Item()