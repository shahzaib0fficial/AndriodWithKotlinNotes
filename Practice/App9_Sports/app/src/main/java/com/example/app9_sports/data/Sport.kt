package com.example.app9_sports.data

import androidx.annotation.DrawableRes
import com.example.app9_sports.R

data class Sport (
    val id: Int = -1,
    val Title: String = "",
    val BasicInfo: String = "",
    val Description: String = "",
    val Players: String = "",
    val Olympics: Boolean = false,
    @DrawableRes val image: Int = R.drawable.blank
)