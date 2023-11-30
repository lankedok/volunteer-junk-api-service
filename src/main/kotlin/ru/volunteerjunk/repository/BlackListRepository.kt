package ru.volunteerjunk.repository

import org.springframework.data.repository.CrudRepository
import ru.volunteerjunk.entity.BlackListEntity

interface BlackListRepository: CrudRepository<BlackListEntity, Int> {

}