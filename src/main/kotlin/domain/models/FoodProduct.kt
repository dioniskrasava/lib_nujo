package org.example.domain.models

import java.time.LocalDate

// модели данных

data class FoodProduct(
    val id: String,
    val name: String,
    val proteins: Double,    // белки
    val fats: Double,        // жиры
    val carbohydrates: Double, // углеводы
    val calories: Double,
    val micronutrients: List<Micronutrient> = emptyList()
)

data class Micronutrient(
    val name: String,
    val amount: Double,
    val unit: String
)

data class DailyConsumption(
    val date: LocalDate,
    val consumedProducts: List<ConsumedProduct>,
    val totalNutrients: NutrientSummary
)

data class ConsumedProduct(
    val product: FoodProduct,
    val quantity: Double // в граммах или порциях
)

data class NutrientSummary(
    val totalProteins: Double,
    val totalFats: Double,
    val totalCarbohydrates: Double,
    val totalCalories: Double
)