package com.alexhernandez.tfgperros.service

import com.alexhernandez.tfgperros.model.User
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun registerUser(user: User): String
}