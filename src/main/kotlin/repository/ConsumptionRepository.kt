package org.example.repository

import org.example.domain.models.DailyConsumption
import org.example.domain.models.FoodProduct
import java.time.LocalDate


interface ConsumptionRepository {
    suspend fun getDailyConsumption(date: LocalDate): DailyConsumption?
    suspend fun addConsumption(product: FoodProduct, quantity: Double)
    suspend fun removeConsumption(consumptionId: String)
    suspend fun getConsumptionPeriod(from: LocalDate, to: LocalDate): List<DailyConsumption>
}