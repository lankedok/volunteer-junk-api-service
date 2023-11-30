package ru.volunteerjunk.service

import ru.volunteerjunk.dto.BlackListDto

interface BlackListService {
    fun getAll() : List<BlackListDto>
}