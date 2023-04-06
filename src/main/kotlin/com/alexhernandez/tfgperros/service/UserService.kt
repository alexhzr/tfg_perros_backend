package com.alexhernandez.tfgperros.service

import com.alexhernandez.tfgperros.model.ServiceResponse
import com.alexhernandez.tfgperros.model.User
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun registerUser(user: User): ServiceResponse
    fun getUserByDNI(dni: String): User?
    fun checkIfUserExists(dni: String, email: String): Boolean
}