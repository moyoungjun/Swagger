package com.example.doc

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import springfox.documentation.swagger.web.SwaggerResource

@RestController
class Controller (
    val defaultSwaggerResourceProvider: DefaultSwaggerResourceProvider
        ){
    @GetMapping("/ad")
    fun all(): MutableList<SwaggerResource> {
        val a =defaultSwaggerResourceProvider.get()
        return a
    }
}