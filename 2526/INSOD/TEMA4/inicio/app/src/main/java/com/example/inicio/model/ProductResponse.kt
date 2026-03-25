package com.example.inicio.model

data class ProductResponse(
    val total: Long? = null,
    val limit: Long? = null,
    val skip: Long? = null,
    val products: List<Product>? = null,
)

data class Product(
    val id: Long? = null,
    val title: String? = null,
    val description: String? = null,
    val category: Category? = null,
    val price: Double? = null,
    val discountPercentage: Double? = null,
    val rating: Double? = null,
    val stock: Long? = null,
    val tags: List<String>? = null,
    val brand: String? = null,
    val sku: String? = null,
    val weight: Long? = null,
    val dimensions: Dimensions? = null,
    val warrantyInformation: String? = null,
    val shippingInformation: String? = null,
    val availabilityStatus: AvailabilityStatus? = null,
    val reviews: List<Review>? = null,
    val returnPolicy: String? = null,
    val minimumOrderQuantity: Long? = null,
    val meta: Meta? = null,
    val images: List<String>? = null,
    val thumbnail: String? = null
)

enum class AvailabilityStatus {
    InStock,
    LowStock
}

enum class Category {
    Beauty,
    Furniture,
    Groceries
}

data class Dimensions(
    val width: Double? = null,
    val height: Double? = null,
    val depth: Double? = null
)

data class Meta(
    val createdAt: String? = null,
    val updatedAt: String? = null,
    val barcode: String? = null,
    val qrCode: String? = null
)

data class Review(
    val rating: Long? = null,
    val comment: String? = null,
    val date: String? = null,
    val reviewerName: String? = null,
    val reviewerEmail: String? = null
)
