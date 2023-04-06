package com.alexhernandez.tfgperros.model

data class ServiceResponse(
    val success: Boolean,
    val message: String,
    val exceptionThrow: Boolean = false,
    val exception: String = ""
) {
    fun getMessageOrException(): String {
        return if (exceptionThrow) exception else message
    }
}