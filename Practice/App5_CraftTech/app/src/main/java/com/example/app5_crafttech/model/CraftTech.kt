package com.example.app5_crafttech.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CraftTech (
    @StringRes val name: Int,
    val view: Int,
    @DrawableRes val image: Int
)