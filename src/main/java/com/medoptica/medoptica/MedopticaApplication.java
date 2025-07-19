package com.medoptica.medoptica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MedopticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedopticaApplication.class, args);
	}

}
