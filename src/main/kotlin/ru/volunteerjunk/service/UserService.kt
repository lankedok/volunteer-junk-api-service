package ru.volunteerjunk.service

import ru.volunteerjunk.entity.UserEntity
import ru.volunteerjunk.repository.UserRepository

interface UserService {
    fun save(user: UserEntity): UserEntity
}