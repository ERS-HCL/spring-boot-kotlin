package com.hcl.ers.spring_boot_kotlin

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class KotlinAppDemo

fun main(args: Array<String>) {
    SpringApplication.run(KotlinAppDemo::class.java, *args)
}
