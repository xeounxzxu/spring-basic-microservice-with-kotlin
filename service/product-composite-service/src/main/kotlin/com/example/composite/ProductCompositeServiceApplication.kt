package com.example.composite

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.runApplication

@SpringBootApplication
@ConfigurationPropertiesScan
open class ProductCompositeServiceApplication

fun main(args: Array<String>) {
    runApplication<ProductCompositeServiceApplication>(*args)
}
