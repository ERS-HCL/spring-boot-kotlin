package com.hcl.ers.spring_boot_kotlin

import org.springframework.stereotype.Service

@Service
class KotlinService {

    fun getHello(): String {
        return "Service message from KotlinService program"
    }
}
