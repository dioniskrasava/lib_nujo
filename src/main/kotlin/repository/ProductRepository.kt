package org.example.repository

import org.example.domain.models.FoodProduct

// репозитории (интерфейсы)

interface ProductRepository {
    suspend fun getAllProducts(): List<FoodProduct>
    suspend fun searchProducts(query: String): List<FoodProduct>
    suspend fun addProduct(product: FoodProduct)
    suspend fun removeProduct(productId: String)
}

