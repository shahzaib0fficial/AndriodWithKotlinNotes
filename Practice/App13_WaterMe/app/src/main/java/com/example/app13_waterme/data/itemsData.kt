package com.example.app13_waterme.data

class itemsData {
    fun data(): List<itemsDataClass>{
        return listOf(
            itemsDataClass(name = "Carrot", description = "I am a Carrot"),
            itemsDataClass(name = "Strawberry", description = "I am a Strawberry")
        )
    }
}