package ru.volunteerjunk.service

import org.springframework.stereotype.Service
import ru.volunteerjunk.dto.Article
import ru.volunteerjunk.repository.ArticleRepository

@Service
class ArticleService(
        private val articleRepository: ArticleRepository
) {
    fun findAll(): List<Article> = articleRepository.findAll()
}