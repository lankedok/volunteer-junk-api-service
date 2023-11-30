package ru.volunteerjunk.entity

import jakarta.persistence.*

@Entity
@Table(name = "black_list_owner")
class BlackListEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Int = 0,
        val name: String = "",
        val surname: String = "",
        val patronymic: String = "",
        val telephone: String = "",
        val address: String = "",
        val city: String = "",
        val social: String = "",
        val reason: String = ""
)