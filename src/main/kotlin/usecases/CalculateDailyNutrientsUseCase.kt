package org.example.usecases

import org.example.domain.models.ConsumedProduct
import org.example.domain.models.NutrientSummary


class CalculateDailyNutrientsUseCase {
    operator fun invoke(consumptions: List<ConsumedProduct>): NutrientSummary {
        return NutrientSummary(
            totalProteins = consumptions.sumOf { it.product.proteins * it.quantity / 100 },
            totalFats = consumptions.sumOf { it.product.fats * it.quantity / 100 },
            totalCarbohydrates = consumptions.sumOf { it.product.carbohydrates * it.quantity / 100 }, // может быть тут ошибка?
            totalCalories = consumptions.sumOf { it.product.calories * it.quantity / 100 }
        )
    }
}