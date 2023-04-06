package com.alexhernandez.tfgperros.controller

import com.alexhernandez.tfgperros.model.User
import com.alexhernandez.tfgperros.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(@Autowired val userService: UserService) {

    @GetMapping("/{userDNI}")
    fun getUsers(@PathVariable userDNI: String) :ResponseEntity<*> {
        val user = userService.getUserByDNI(userDNI)

        return ResponseEntity.ok(user)
    }

    @GetMapping("/search")
    fun checkUserExists(@RequestParam dni: String, @RequestParam email: String) {
        userService.checkIfUserExists(dni, email)
    }


    @PostMapping(consumes = ["application/json"])
    fun registerUser(@RequestBody user: User) :ResponseEntity<*> {
        var resp = userService.registerUser(user)

        return if (resp.success) ResponseEntity.ok(resp.message)
            else if (resp.exceptionThrow) ResponseEntity.internalServerError().body(resp.getMessageOrException())
            else ResponseEntity.badRequest().body(resp.message)
    }
}