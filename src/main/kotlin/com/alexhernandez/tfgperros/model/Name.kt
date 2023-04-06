package com.alexhernandez.tfgperros.model

data class Name(val firstName: String, val lastName: String) {
    constructor(): this("", "")
}