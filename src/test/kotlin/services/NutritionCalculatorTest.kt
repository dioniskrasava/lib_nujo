package org.example.services

//import domain.models.FoodProduct // deepseek сломался)
import org.example.domain.models.FoodProduct
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class NutritionCalculatorTest {

    // Создаем тестовый продукт
    private val testProduct = FoodProduct(
        id = "1",
        name = "Тестовый продукт",
        proteins = 10.0,      // 10г белка на 100г
        fats = 5.0,           // 5г жиров на 100г
        carbohydrates = 20.0, // 20г углеводов на 100г
        calories = 165.0      // 165 ккал на 100г
    )

    private val calculator = NutritionCalculator()

    @Test
    fun `calculate nutritional values for 100 grams`() {
        // Когда: рассчитываем для 100г
        val result = calculator.calculateNutritionalValues(testProduct, 100.0)

        // Тогда: значения должны быть как в продукте (потому что 100г)
        assertEquals(10.0, result["proteins"])
        assertEquals(5.0, result["fats"])
        assertEquals(20.0, result["carbohydrates"])
        assertEquals(165.0, result["calories"])
    }

    @Test
    fun `calculate nutritional values for 200 grams`() {
        // Когда: рассчитываем для 200г (в 2 раза больше)
        val result = calculator.calculateNutritionalValues(testProduct, 200.0)

        // Тогда: значения должны быть в 2 раза больше
        assertEquals(20.0, result["proteins"])  // 10г * 2 = 20г
        assertEquals(10.0, result["fats"])      // 5г * 2 = 10г
        assertEquals(40.0, result["carbohydrates"]) // 20г * 2 = 40г
        assertEquals(330.0, result["calories"]) // 165ккал * 2 = 330ккал
    }

    @Test
    fun `calculate nutritional values for 50 grams`() {
        // Когда: рассчитываем для 50г (половина)
        val result = calculator.calculateNutritionalValues(testProduct, 50.0)

        // Тогда: значения должны быть в 2 раза меньше
        assertEquals(5.0, result["proteins"])   // 10г / 2 = 5г
        assertEquals(2.5, result["fats"])       // 5г / 2 = 2.5г
        assertEquals(10.0, result["carbohydrates"]) // 20г / 2 = 10г
        assertEquals(82.5, result["calories"])  // 165ккал / 2 = 82.5ккал
    }
}