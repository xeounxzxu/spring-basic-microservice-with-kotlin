package com.example.composite.infra.config

import com.example.composite.infra.repository.ReviewClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.support.WebClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory


@Configuration
open class ClientConfiguration(
    private val clientProperties: ClientProperties
) {

    @Bean
    open fun reviewClient(): ReviewClient = WebClient.builder()
        .baseUrl(clientProperties.review.baseUrl)
        .build()
        .let {

            val client = HttpServiceProxyFactory
                .builder()
                .clientAdapter(WebClientAdapter.forClient(it))
                .build()
                .createClient(ReviewClient::class.java)

            client
        }
}
