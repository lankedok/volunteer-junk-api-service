package ru.volunteerjunk.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.volunteerjunk.entity.UserEntity


//может не Crud
@Repository
interface UserRepository : CrudRepository<UserEntity, Int>