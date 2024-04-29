package com.example.app5_crafttech.data

import com.example.app5_crafttech.R
import com.example.app5_crafttech.model.CraftTech

fun listOfCraftTech(): List<CraftTech> {
    return listOf(
        CraftTech(R.string.architecture, 58, R.drawable.architecture),
        CraftTech(R.string.crafts, 121, R.drawable.crafts),
        CraftTech(R.string.business, 78, R.drawable.business),
        CraftTech(R.string.culinary, 118, R.drawable.culinary),
        CraftTech(R.string.design, 423, R.drawable.design),
        CraftTech(R.string.fashion, 92, R.drawable.fashion),
        CraftTech(R.string.film, 165, R.drawable.film),
        CraftTech(R.string.gaming, 164, R.drawable.gaming),
        CraftTech(R.string.drawing, 326, R.drawable.drawing),
        CraftTech(R.string.lifestyle, 305, R.drawable.lifestyle),
        CraftTech(R.string.music, 212, R.drawable.music),
        CraftTech(R.string.painting, 172, R.drawable.painting),
        CraftTech(R.string.photography, 321, R.drawable.photography),
        CraftTech(R.string.tech, 118, R.drawable.tech)
    )
}