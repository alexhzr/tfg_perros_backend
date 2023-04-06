package com.alexhernandez.tfgperros.service.implementation

import com.alexhernandez.tfgperros.model.Name
import com.alexhernandez.tfgperros.model.ServiceResponse
import com.alexhernandez.tfgperros.model.User
import com.alexhernandez.tfgperros.repository.UserRepository
import com.alexhernandez.tfgperros.service.UserService
import com.alexhernandez.tfgperros.util.Messages
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service("UserService")
class UserServiceImpl(@Autowired val userRepository: UserRepository) : UserService {

    override fun registerUser(user: User): ServiceResponse {
        var serviceResponse: ServiceResponse

        if (userRepository.userExists(user.email, user.dni)) {
            serviceResponse = ServiceResponse(false,  Messages.USER_EXISTS)
        } else {
            serviceResponse = if (userRepository.registerUser(user)) ServiceResponse(true, Messages.USER_REGISTERED) else ServiceResponse(false, Messages.USER_ERROR_REGISTERING)
        }

        return serviceResponse
    }

    override fun getUserByDNI(dni: String): User? {
        return userRepository.getUserByDNI(dni)
    }

    override fun checkIfUserExists(dni: String, email: String): Boolean {
        return userRepository.userExists(email,  dni)
    }
}