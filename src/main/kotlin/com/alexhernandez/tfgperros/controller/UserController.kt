package com.alexhernandez.tfgperros.controller

import com.alexhernandez.tfgperros.model.User
import com.alexhernandez.tfgperros.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user", consumes = ["application/json"])
class UserController(@Autowired val userService: UserService) {

    @GetMapping()
    fun getUsers() :ResponseEntity<*> {
        return ResponseEntity.ok("Aqui estás")
    }

    @PostMapping()
    fun registerUser(@RequestBody user: User) :ResponseEntity<*> {
        var response = ResponseEntity.accepted().body("Yes")

        var resp = userService.registerUser(user)

        if (resp != null) {
            response = ResponseEntity.ok(resp)
        } else {
            response = ResponseEntity.badRequest().body("Error: "+resp)
        }

        return response
    }
}