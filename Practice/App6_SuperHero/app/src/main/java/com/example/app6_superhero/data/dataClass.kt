package com.example.app6_superhero.data

import com.example.app6_superhero.R
import com.example.app6_superhero.model.heroLayout

class dataClass {
    fun heroList(): List<heroLayout>{
        return listOf<heroLayout> (
            heroLayout(R.string.hero1, R.string.description1, R.drawable.android_superhero1),
            heroLayout(R.string.hero2, R.string.description2, R.drawable.android_superhero2),
            heroLayout(R.string.hero3, R.string.description3, R.drawable.android_superhero3),
            heroLayout(R.string.hero4, R.string.description4, R.drawable.android_superhero4),
            heroLayout(R.string.hero5, R.string.description5, R.drawable.android_superhero5),
            heroLayout(R.string.hero6, R.string.description6, R.drawable.android_superhero6),
        )
    }
}
