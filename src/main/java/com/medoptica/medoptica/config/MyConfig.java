package com.medoptica.medoptica.config;

import com.medoptica.medoptica.service.NovaPoshtaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@Configuration
public class MyConfig {
    @Autowired
    RestTemplate restTemplate;
    private String host;

    @Bean
    public NovaPoshtaService novaPoshtaService() {
        return new NovaPoshtaService("https://api.novaposhta.ua/v2.0/json/", restTemplate);
    }

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("andrijvecirko2@gmail.com");
        mailSender.setPassword("ceft hxke ygym slgm");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        return mailSender;
    }
}