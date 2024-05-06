package com.example.app7_30days.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CookingClass (
    @StringRes val day: Int,
    @StringRes val title: Int,
    @DrawableRes val image: Int,
    @StringRes val description: Int
)