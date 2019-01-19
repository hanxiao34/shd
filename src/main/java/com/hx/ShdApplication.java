package com.hx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com.hx.repositories")
public class ShdApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShdApplication.class, args);
	}

}

