package com.example.aldebaran;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AldebaranApplication {

	public static void main(String[] args) {
		SpringApplication.run(AldebaranApplication.class, args);
	}

}
