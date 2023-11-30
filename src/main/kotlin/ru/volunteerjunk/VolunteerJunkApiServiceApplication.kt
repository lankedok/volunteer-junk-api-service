package ru.volunteerjunk

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication
class VolunteerJunkApiServiceApplication

fun main(args: Array<String>) {
	runApplication<VolunteerJunkApiServiceApplication>(*args)
}
