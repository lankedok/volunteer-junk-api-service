package ru.volunteerjunk.service

import org.springframework.stereotype.Service
import ru.volunteerjunk.dto.User
import ru.volunteerjunk.repository.UserRepository
import java.util.UUID

@Service
class UserService(
        private val userRepository: UserRepository
) {
    fun createUser(user: User): User? {
        val found = userRepository.findByEmail(user.email)

        return if (found == null) {
            userRepository.save(user)
            user
        } else null
    }

    fun findByUUID(uuid: UUID): User? = userRepository.findByUUID(uuid)

    fun findAll(): List<User> = userRepository.findAll()

    fun deleteByUUID(uuid: UUID): Boolean = userRepository.deleteByUUID(uuid)
}