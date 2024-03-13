package com.smedina.generic_store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GenericStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenericStoreApplication.class, args);
	}

}
