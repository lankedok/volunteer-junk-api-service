package ru.volunteerjunk.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import ru.volunteerjunk.dto.UserDto
import ru.volunteerjunk.entity.UserEntity
import ru.volunteerjunk.repository.UserRepository
import ru.volunteerjunk.service.UserService

@Service
class UserServiceImpl( private val userRepository: UserRepository) : UserService {
    override fun save(user: UserEntity): UserEntity {
        return this.userRepository.save(user)
    }
}