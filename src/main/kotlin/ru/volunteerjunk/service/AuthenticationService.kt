package ru.volunteerjunk.service

import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import ru.volunteerjunk.config.JwtProperties
import ru.volunteerjunk.controller.auth.AuthenticationRequest
import ru.volunteerjunk.controller.auth.AuthenticationResponse
import ru.volunteerjunk.repository.RefreshTokenRepository
import java.util.*

@Service
class AuthenticationService(
        private val authManager: AuthenticationManager,
        private val userDetailService: CustomUserDetailService,
        private val tokenService: TokenService,
        private val jwtProperties: JwtProperties,
        private val refreshTokenRepository: RefreshTokenRepository
) {
    fun authentication(authRequest: AuthenticationRequest): AuthenticationResponse {
        authManager.authenticate(
                UsernamePasswordAuthenticationToken(
                        authRequest.email,
                        authRequest.password
                )
        )

        val user = userDetailService.loadUserByUsername(authRequest.email)
        val accessToken = generateAccessToken(user)
        val refreshToken = generateRefreshToken(user)

        refreshTokenRepository.save(refreshToken, user)

        return AuthenticationResponse(
                accessToken = accessToken,
                refreshToken = refreshToken
        )
    }

    fun refreshAccessToken(token: String): String? {
        val extractedEmail = tokenService.extractEmail(token)

        return extractedEmail?.let { email ->
            val currentUserDetails = userDetailService.loadUserByUsername(email)
            val refreshTokenUserDetails = refreshTokenRepository.findUserDetailsByToken(token)

            if (!tokenService.isExpired(token) && currentUserDetails.username == refreshTokenUserDetails?.username)
                generateAccessToken(currentUserDetails)
            else
                null
        }
    }

    private fun generateAccessToken(user: UserDetails) = tokenService.generate(
            userDetails = user,
            expirationDate = Date(System.currentTimeMillis() + jwtProperties.accessTokenExpiration)
    )

    private fun generateRefreshToken(user: UserDetails) = tokenService.generate(
            userDetails = user,
            expirationDate = Date(System.currentTimeMillis() + jwtProperties.accessTokenExpiration)
    )
}