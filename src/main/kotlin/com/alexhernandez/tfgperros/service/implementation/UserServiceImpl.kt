package com.alexhernandez.tfgperros.service.implementation

import com.alexhernandez.tfgperros.model.User
import com.alexhernandez.tfgperros.repository.UserRepository
import com.alexhernandez.tfgperros.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("UserService")
class UserServiceImpl(@Autowired val userRepository: UserRepository) : UserService {
//    @Autowired
//    val userRepository = UserRepository()

    override fun registerUser(user: User):String {
        return userRepository.registerUser(user)
    }
}