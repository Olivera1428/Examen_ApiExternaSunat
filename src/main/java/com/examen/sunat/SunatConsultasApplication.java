package com.examen.sunat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SunatConsultasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SunatConsultasApplication.class, args);
	}

}
