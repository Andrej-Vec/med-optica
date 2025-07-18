package com.medoptica.medoptica.config;

import com.medoptica.medoptica.service.NovaPoshtaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {
    @Autowired
    RestTemplate restTemplate;
    private String host;

    @Bean
    public NovaPoshtaService novaPoshtaService() {
        return new NovaPoshtaService("https://api.novaposhta.ua/v2.0/json/", restTemplate);
    }
}