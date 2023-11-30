package ru.volunteerjunk.dto

data class BlackListDto(
        val id: Int,
        val name: String,
        val surname: String,
        val patronymic: String,
        val telephone: String,
        val address: String,
        val city: String,
        val social: String,
        val reason: String
)
