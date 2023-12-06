package ru.volunteerjunk.controller.auth

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.server.ResponseStatusException
import ru.volunteerjunk.service.AuthenticationService

@RestController
@RequestMapping("/api/auth")
class AuthController(
        private val authenticationService: AuthenticationService
) {

    @PostMapping
    fun authenticate(@RequestBody authRequest: AuthenticationRequest): AuthenticationResponse =
            authenticationService.authentication(authRequest)
}