package ru.volunteerjunk.repository

import org.springframework.stereotype.Repository
import ru.volunteerjunk.dto.Article
import java.util.*

@Repository
class ArticleRepository {

    private val articles = listOf(
            Article(id = UUID.randomUUID(), title = "1", content = "2"),
            Article(id = UUID.randomUUID(), title = "2", content = "3"),
            Article(id = UUID.randomUUID(), title = "3", content = "4")
    )

    fun findAll() : List<Article> = articles

}