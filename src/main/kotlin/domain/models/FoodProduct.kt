package org.example.domain.models

/**
 * Данные для работы приложения.
 *
 *
 * */

import java.time.LocalDate

// модели данных

// продукт
/**
 * ДОБАВИТЬ КЛЕТЧАТКУ
 * ДОБАВИТ КЛАСС БЖУ
 *
 * */
data class FoodProduct(
    val id: String,
    val name: String,
    val proteins: Double,    // белки
    val fats: Double,        // жиры
    val carbohydrates: Double, // углеводы
    val calories: Double,
    val micronutrients: List<Micronutrient> = emptyList()
)

// ДОБАВИТЬ КЛАСС ВИТАМИНОВ

// ДОБАВИТЬ КЛАСС МИНЕРАЛОВ

// микронутриенты
data class Micronutrient(
    val name: String,
    val amount: Double,     // количество
    val unit: String        // единицы измерения
)

// дневное потребление
data class DailyConsumption(
    val date: LocalDate,
    val consumedProducts: List<ConsumedProduct>,
    val totalNutrients: NutrientSummary
)

// потребляемый (съеденный) продукт
data class ConsumedProduct(
    val product: FoodProduct,
    val quantity: Double // в граммах или порциях
)


// резюме (сводка) по нутриентам
data class NutrientSummary(
    val totalProteins: Double,
    val totalFats: Double,
    val totalCarbohydrates: Double,
    val totalCalories: Double
)