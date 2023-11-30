package ru.volunteerjunk.service

import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ru.volunteerjunk.repository.UserRepository

typealias ApplicationUser = ru.volunteerjunk.dto.User

@Service
class CustomUserDetailService(
        private val userRepository: UserRepository
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails =
            userRepository.findByEmail(username)
                    ?.mapToUserDetails()
                    ?: throw UsernameNotFoundException("Not found!")

    private fun ApplicationUser.mapToUserDetails(): UserDetails =
            User.builder()
                    .username(this.email)
                    .password(this.password)
                    .roles(this.role.name)
                    .build()
}