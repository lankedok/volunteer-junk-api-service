package ru.volunteerjunk.entity

import jakarta.persistence.*
import jdk.jfr.DataAmount

@Entity
@Table(name = "black_list_owner")
class BlackListEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column
        val id: Int = 0,
        @Column
        val name: String = "",
        @Column
        val surname: String = "",
        @Column
        val patronymic: String = "",
        @Column
        val telephone: String = "",
        @Column
        val address: String = "",
        @Column
        val city: String = "",
        @Column
        val social: String = "",
        @Column
        val reason: String = "",
        @Column
        val author: String = ""
)