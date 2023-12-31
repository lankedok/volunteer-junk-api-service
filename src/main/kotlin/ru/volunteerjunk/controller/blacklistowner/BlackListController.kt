package ru.volunteerjunk.controller.blacklistowner

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.volunteerjunk.dto.BlackListDto
import ru.volunteerjunk.service.BlackListService

class BlackListController {
    @RestController
    @RequestMapping("/blackListAll")
    class BlackListController(
            private val blackList: BlackListService
    ) {

        @GetMapping
        fun getAll(): List<BlackListDto> = blackList.getAll()
    }
}