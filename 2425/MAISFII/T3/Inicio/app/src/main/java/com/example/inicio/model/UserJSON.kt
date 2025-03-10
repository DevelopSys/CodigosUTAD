package com.example.inicio.model

data class UserJSON (
    val id: Long? = null,
    val firstName: String? = null,
    val lastName: String? = null,
    val maidenName: String? = null,
    val age: Long? = null,
    val gender: String? = null,
    val email: String? = null,
    val phone: String? = null,
    val username: String? = null,
    val password: String? = null,
    val birthDate: String? = null,
    val image: String? = null,
    val bloodGroup: String? = null,
    val height: Double? = null,
    val weight: Double? = null,
    val eyeColor: String? = null,
    val hair: Hair? = null,
    val ip: String? = null,
    val address: Address? = null,
    val macAddress: String? = null,
    val university: String? = null,
    val bank: Bank? = null,
    val company: Company? = null,
    val ein: String? = null,
    val ssn: String? = null,
    val userAgent: String? = null,
    val crypto: Crypto? = null,
    val role: String? = null
)

data class Address (
    val address: String? = null,
    val city: String? = null,
    val state: String? = null,
    val stateCode: String? = null,
    val postalCode: String? = null,
    val coordinates: Coordinates? = null,
    val country: String? = null
)

data class Coordinates (
    val lat: Double? = null,
    val lng: Double? = null
)

data class Bank (
    val cardExpire: String? = null,
    val cardNumber: String? = null,
    val cardType: String? = null,
    val currency: String? = null,
    val iban: String? = null
)

data class Company (
    val department: String? = null,
    val name: String? = null,
    val title: String? = null,
    val address: Address? = null
)

data class Crypto (
    val coin: String? = null,
    val wallet: String? = null,
    val network: String? = null
)

data class Hair (
    val color: String? = null,
    val type: String? = null
)
