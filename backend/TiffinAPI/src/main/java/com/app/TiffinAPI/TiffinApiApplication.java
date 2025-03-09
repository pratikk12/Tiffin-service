package com.app.TiffinAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.app.TiffinAPI.repository")
public class TiffinApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiffinApiApplication.class, args);
		System.out.println("Hello world");
	}

}
