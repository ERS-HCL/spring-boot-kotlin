package com.hcl.ers.spring_boot_kotlin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class KotlinController(val kotlinService: KotlinService) {

    @GetMapping("/kotlin")
    fun helloKotlin(): String {
        return "Hello world message from KotlinController program"
    }

    @GetMapping("/kotlin-service")
    fun helloKotlinService(): String {
        return kotlinService.getHello()
    }

    @GetMapping("/kotlin-dto")
    fun helloKotlinDto(): KotlinDTO {
        return KotlinDTO("Hello message from new KotlinDTO instance")
    }    
}