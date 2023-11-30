package ru.volunteerjunk.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.volunteerjunk.dto.UserDto
import ru.volunteerjunk.entity.UserEntity
import ru.volunteerjunk.service.UserService

@RestController
@RequestMapping
class UserController(private val userService: UserService) {

    @PostMapping("/registrationUser")
    fun registration(@RequestBody body: UserDto): ResponseEntity<UserEntity> { //мб вернуть UserEntity
        val user = UserEntity()
        user.name = body.name
        user.email = body.email
        user.password = body.password
        return ResponseEntity.ok(this.userService.save(user))
    }
}