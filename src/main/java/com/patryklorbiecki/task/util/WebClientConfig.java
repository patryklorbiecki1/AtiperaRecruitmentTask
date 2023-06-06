package com.patryklorbiecki.task.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    private static final String GITHUB_API_URL = "https://api.github.com";
    @Bean
    public WebClient getWebClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder
                .baseUrl(GITHUB_API_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}