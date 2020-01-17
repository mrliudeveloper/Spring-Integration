package com.mrliu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TestSpringbootAndActiveMqApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringbootAndActiveMqApplication.class, args);
	}

}
