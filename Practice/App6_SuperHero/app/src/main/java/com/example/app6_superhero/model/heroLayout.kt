package com.example.app6_superhero.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class heroLayout (
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val imageId: Int
)