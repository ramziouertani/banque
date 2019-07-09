package com.guichet.banque;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GuichetApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuichetApplication.class, args);
	}

}
