package org.example.usecases

import org.example.domain.models.FoodProduct
import org.example.repository.ConsumptionRepository


// use cases (бизнес-логика)

class AddConsumptionUseCase(
    private val consumptionRepository: ConsumptionRepository
) {
    suspend operator fun invoke(product: FoodProduct, quantity: Double) {
        consumptionRepository.addConsumption(product, quantity)
    }
}


