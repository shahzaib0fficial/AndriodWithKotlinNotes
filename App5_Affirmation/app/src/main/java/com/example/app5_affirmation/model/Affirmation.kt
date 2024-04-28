package com.example.app5_affirmation.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Affirmation (
    @StringRes val stringResorceId: Int,
    @DrawableRes val imageResourceId: Int
)