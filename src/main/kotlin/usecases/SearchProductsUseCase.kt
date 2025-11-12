package org.example.usecases

import org.example.domain.models.FoodProduct
import org.example.repository.ProductRepository


// core/src/main/kotlin/usecases/SearchProductsUseCase.kt
class SearchProductsUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(query: String): List<FoodProduct> {
        return productRepository.searchProducts(query)
    }
}