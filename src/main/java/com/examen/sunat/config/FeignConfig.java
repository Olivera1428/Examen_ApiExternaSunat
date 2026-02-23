package com.examen.sunat.config;

import feign.RequestInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Value("${decolecta.token}")
    private String token;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return template ->
                template.header("Authorization", "Bearer " + token);
    }
}