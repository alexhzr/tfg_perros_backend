package com.alexhernandez.tfgperros.model

data class User(
    val name: Name,
    val email: String,
    val dni: String,
    val userType: Int
    ) {
}