package ru.volunteerjunk.entity

import jakarta.persistence.*
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@Entity
@Table(name = "users")
class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //если что поменяю
    //не понятно тут var или val
    val id: Int = 0
    //нужно ли использовать @Column
    //по котлину: чот null не работает
    var name: String = ""
    var email: String = ""
    var password: String = ""

}