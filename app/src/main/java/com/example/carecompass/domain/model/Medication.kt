package com.example.carecompass.domain.model

data class Medication(
    val id: String = System.currentTimeMillis().toString(),
    val name: String,
    val time: String
)
