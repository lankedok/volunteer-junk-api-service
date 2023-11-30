package ru.volunteerjunk.service

import org.springframework.context.annotation.Bean
import ru.volunteerjunk.dto.BlackListDto

interface BlackListService {
    fun getAll() : List<BlackListDto>
}