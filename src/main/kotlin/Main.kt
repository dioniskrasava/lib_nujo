package org.example

import org.example.domain.models.ConsumedProduct
import org.example.domain.models.FoodProduct
import org.example.domain.models.Micronutrient
import org.example.services.NutritionCalculator
import org.example.usecases.CalculateDailyNutrientsUseCase


fun main() {
    println("=== Тестирование библиотеки питания ===\n")

    // Создаем тестовые данные
    val apple = FoodProduct(
        id = "1",
        name = "Яблоко",
        proteins = 0.3,
        fats = 0.2,
        carbohydrates = 14.0,
        calories = 52.0,
        micronutrients = listOf(
            Micronutrient("Витамин C", 4.6, "mg"),
            Micronutrient("Калий", 107.0, "mg")
        )
    )

    val chickenBreast = FoodProduct(
        id = "2",
        name = "Куриная грудка",
        proteins = 31.0,
        fats = 3.6,
        carbohydrates = 0.0,
        calories = 165.0,
        micronutrients = listOf(
            Micronutrient("Железо", 1.0, "mg"),
            Micronutrient("Цинк", 1.0, "mg")
        )
    )

    println("Созданные продукты:")
    println("- ${apple.name}: ${apple.calories} ккал/100г")
    println("- ${chickenBreast.name}: ${chickenBreast.proteins}г белка/100г")

    // Тестируем NutritionCalculator
    val calculator = NutritionCalculator()
    val appleNutrition = calculator.calculateNutritionalValues(apple, 150.0)
    val chickenNutrition = calculator.calculateNutritionalValues(chickenBreast, 200.0)

    println("\n=== Расчет питательности ===")
    println("Яблоко 150г:")
    println("  Белки: ${appleNutrition["proteins"]}г")
    println("  Жиры: ${appleNutrition["fats"]}г")
    println("  Углеводы: ${appleNutrition["carbohydrates"]}г")
    println("  Калории: ${appleNutrition["calories"]}ккал")

    println("\nКуриная грудка 200г:")
    println("  Белки: ${chickenNutrition["proteins"]}г")
    println("  Жиры: ${chickenNutrition["fats"]}г")
    println("  Калории: ${chickenNutrition["calories"]}ккал")

    // Тестируем CalculateDailyNutrientsUseCase
    val dailyCalculator = CalculateDailyNutrientsUseCase()
    val consumptions = listOf(
        ConsumedProduct(apple, 150.0),
        ConsumedProduct(chickenBreast, 200.0)
    )

    val dailySummary = dailyCalculator(consumptions)

    println("\n=== Итоги за день ===")
    println("Всего белков: ${dailySummary.totalProteins}г")
    println("Всего жиров: ${dailySummary.totalFats}г")
    println("Всего углеводов: ${dailySummary.totalCarbohydrates}г")
    println("Всего калорий: ${dailySummary.totalCalories}ккал")
}