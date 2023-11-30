package ru.volunteerjunk.config

import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import ru.volunteerjunk.repository.UserRepository
import ru.volunteerjunk.service.CustomUserDetailService

@Configuration
@EnableConfigurationProperties(JwtProperties::class)
class Configuration {

    @Bean
    @Primary
    fun userDetailsService(userRepository: UserRepository): UserDetailsService =
            CustomUserDetailService(userRepository)

    @Bean
    fun encoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun authenticationProvider(userRepository: UserRepository): AuthenticationProvider =
            DaoAuthenticationProvider()
                    .also {
                        it.setUserDetailsService(userDetailsService(userRepository))
                        it.setPasswordEncoder(encoder())
                    }

    @Bean
    fun authenticationManager(config: AuthenticationConfiguration): AuthenticationManager =
            config.authenticationManager
}