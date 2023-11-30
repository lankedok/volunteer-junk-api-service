package ru.volunteerjunk.service.impl

import org.springframework.stereotype.Service
import ru.volunteerjunk.dto.BlackListDto
import ru.volunteerjunk.entity.BlackListEntity
import ru.volunteerjunk.repository.BlackListRepository
import ru.volunteerjunk.service.BlackListService

@Service
class BlackListServiceImpl(
        private val blackListRepository: BlackListRepository
) : BlackListService {
    override fun getAll(): List<BlackListDto> {
        return blackListRepository.findAll().map { it.toDto() }
    }

    private fun BlackListEntity.toDto(): BlackListDto =
            BlackListDto(
                    id = this.id,
                    name = this.name,
                    surname = this.surname,
                    patronymic = this.patronymic,
                    telephone = this.telephone,
                    address = this.address,
                    city = this.city,
                    social = this.social,
                    reason = this.reason
            )

}