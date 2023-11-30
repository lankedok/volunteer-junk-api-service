package ru.volunteerjunk.controller.auth

data class AuthenticationRequest(
        val email: String,
        val password: String
)
