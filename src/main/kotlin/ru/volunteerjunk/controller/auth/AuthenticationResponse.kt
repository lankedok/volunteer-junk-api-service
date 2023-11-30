package ru.volunteerjunk.controller.auth

data class AuthenticationResponse(
        val accessToken: String,
        val refreshToken: String
)