package com.example.rrowllow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class RrowllowApplication {

	public static void main(String[] args) {
		SpringApplication.run(RrowllowApplication.class, args);
	}

}
