package org.example.services

import org.example.domain.models.FoodProduct


class NutritionCalculator {
    fun calculateNutritionalValues(
        product: FoodProduct,
        quantity: Double
    ): Map<String, Double> {
        return mapOf(
            "proteins" to product.proteins * quantity / 100,
            "fats" to product.fats * quantity / 100,
            "carbohydrates" to product.carbohydrates * quantity / 100,
            "calories" to product.calories * quantity / 100
        )
    }
}