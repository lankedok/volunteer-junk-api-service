package ru.volunteerjunk.repository

import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository
import ru.volunteerjunk.dto.Role
import ru.volunteerjunk.dto.User
import java.util.*

@Repository
class UserRepository(private val encoder: PasswordEncoder) {

    private val users = mutableListOf(
            User(
                    id = UUID.randomUUID(),
                    email = "ex1@gmail.com",
                    password = encoder.encode("pass1") ,
                    role = Role.USER
            ),
            User(
                    id = UUID.randomUUID(),
                    email = "ex2@gmail.com",
                    password = encoder.encode("pass2"),
                    role = Role.ADMIN
            ),
            User(
                    id = UUID.randomUUID(),
                    email = "ex3@gmail.com",
                    password = encoder.encode("pass3"),
                    role = Role.USER
            )

    )

    fun save(user: User): Boolean {
        val updated = user.copy(password = encoder.encode(user.password))
        return users.add(updated)
    }

    fun findByEmail(email: String): User? = users.firstOrNull { it.email == email }

    fun findAll(): List<User> = users

    fun findByUUID(uuid: UUID): User? = users.firstOrNull { it.id == uuid }

    fun deleteByUUID(uuid: UUID): Boolean {
        val foundUser = findByUUID(uuid)
        return foundUser?.let {
            users.remove(it)
        } ?: false
    }
}