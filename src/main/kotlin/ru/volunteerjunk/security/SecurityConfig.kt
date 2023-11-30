package ru.volunteerjunk.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder


val PASSWORD_ENCODER: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()
@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun passwordEncoder() = PASSWORD_ENCODER

}