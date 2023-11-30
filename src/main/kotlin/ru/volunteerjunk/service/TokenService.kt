package ru.volunteerjunk.service

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import ru.volunteerjunk.config.JwtProperties
import java.util.Date

@Service
class TokenService(
        jwtProperties: JwtProperties
) {
    private val secretKey = Keys.hmacShaKeyFor(
            jwtProperties.key.toByteArray()
    )

    fun generate(
            userDetails: UserDetails,
            expirationDate: Date,
            additionalClaims: Map<String, Any> = emptyMap()
    ): String =
            Jwts.builder().claims().subject(userDetails.username)
                    .issuedAt(Date(System.currentTimeMillis()))
                    .expiration(expirationDate)
                    .add(additionalClaims)
                    .and()
                    .signWith(secretKey)
                    .compact()

    fun extractEmail(token: String): String = getAllClaims(token).subject

    fun isExpired(token: String): Boolean =
            getAllClaims(token)
                    .expiration
                    .before(Date(System.currentTimeMillis()))

    fun isValid(token: String, userDetails: UserDetails): Boolean {
        val email = extractEmail(token)

        return userDetails.username == email && !isExpired(token)
    }

    private fun getAllClaims(token: String): Claims {
        val parses = Jwts.parser()
                .verifyWith(secretKey)
                .build()

        return parses
                .parseSignedClaims(token)
                .payload
    }
}