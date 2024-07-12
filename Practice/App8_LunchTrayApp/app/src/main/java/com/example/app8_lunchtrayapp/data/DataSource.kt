package com.example.app8_lunchtrayapp.data

class DataSource {
    fun EntreeList() : List<Triple<String, String, String>>
    {
        return listOf(
            Triple(
                "Cauliflower",
                "Whole cauliflower,brined,roasted and deep fried",
                "7.00"
            ),
            Triple(
                "Three Bean Chilli",
                "Black bean, red bean, kidney bean, slow cooked, topped with onion",
                "4.00"
            ),
            Triple(
                "Mushroom Pasta",
                "Penne Pasta, mushroom, with plumed tomato cooked in garlic and olive oil",
                "5.50"
            ),
            Triple(
            "Spicy Black Bean Skillet",
            "Seasonal vegetables, black bean, house spice blend, served with avocado and quick pickled onion",
            "5.50"
        )
        )
    }
    fun SideDishList() : List<Triple<String, String, String>>
    {
        return listOf(
            Triple(
                "Summer Salad",
                "Heirloom tomatoes, butter lettuce, peaches avocado, balsamic dressing",
                "2.50"
            ),
            Triple(
                "Butternut Squash Soup",
                "Roasted buttered squash roasted paper chilli oil",
                "3.00"
            ),
            Triple(
                "Spicy Potato",
                "Marble potatoes, roasted and fried in house space blend",
                "2.00"
            ),
            Triple(
                "Coconut Oil",
                "Rice, coconut milk, lime and sugar",
                "1.50"
            )
        )
    }
    fun AccompanientList() : List<Triple<String, String, String>>
    {
        return listOf(
            Triple(
                "Lunch Roll",
                "Fresh Baked roll made in house",
                "0.50"
            ),
            Triple(
                "Mixed Berries",
                "Strawberries, Blueberries, Raspberries, and huckleberries",
                "1.00"
            ),
            Triple(
                "Pickled Veggies",
                "Pickled cucumbers and carrots, made in house",
                "0.50"
            )
        )
    }
}